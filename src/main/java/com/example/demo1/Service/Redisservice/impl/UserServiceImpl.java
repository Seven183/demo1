package com.example.demo1.Service.Redisservice.impl;


import com.example.demo1.Dao.Redisdao.UserDao;
import com.example.demo1.POJO.Redispojo.User;
import com.example.demo1.Service.Redisservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**** imports ****/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao = null;

	// 插入用户，最后MyBatis会回填id，取结果id缓存用户
    // get redis_user_id 获取该键的值
    // ttl redis_user_id 获取剩余缓存的时间
	@Override
	@Transactional
    //key = "'redis_user_'+#id"必须要传入一个id参数
    //#result.id取出MyBatis会回填id，取结果id缓存用户
	@CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
	public User insertUser(User user) {
		userDao.insertUser(user);
		return user;
	}

	// 获取id，取参数id缓存用户
	@Override
	@Transactional
    //key = "'redis_user_'+#id"必须要传入一个id参数
	@Cacheable(value = "redisCache", key = "'redis_user_'+#id")
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	// 更新数据后，充值缓存，使用condition配置项使得结果返回为null，不缓存
	@Override
	@Transactional
    //key = "'redis_user_'+#id"必须要传入一个id参数,且在redis中以'redis_user_'+#id为键存储值
    //condition = "#result != 'null'"返回的值不为null是有缓存，为null是不开启缓存
	@CachePut(value = "redisCache", condition = "#result != 'null'", key = "'redis_user_'+#id")
	public User updateUserName(Long id, String userName) {
		// 此处调用getUser方法，该方法缓存注解失效，
		// 所以这里还会执行SQL，将查询到数据库最新数据
		User user = this.getUser(id);
		if (user == null) {
			return null;
		}
		user.setUserName(userName);
		userDao.updateUser(user);
		return user;

	}

	// 命中率低，所以不采用缓存机制
	@Override
	@Transactional
	public List<User> findUsers(User user) {
		return userDao.findUsers(user.getUserName(), user.getNote());
	}

	// 移除缓存
	@Override
	@Transactional
    //beforeInvocation = false默认为方法之后移除缓存，value = "redisCache"缓存的名称，配置文件中配置的
	@CacheEvict(value = "redisCache", key = "'redis_user_'+#id", beforeInvocation = false)
	public int deleteUser(Long id) {
		return userDao.deleteUser(id);
	}
}