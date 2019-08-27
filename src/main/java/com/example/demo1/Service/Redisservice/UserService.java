package com.example.demo1.Service.Redisservice;


import com.example.demo1.POJO.Redispojo.User;

import java.util.List;

/**** imports ****/
public interface UserService {
    // 获取单个用户
    User getUser(Long id);
    
    // 保存用户
    User insertUser(User user);
    
    // 修改用户，指定MyBatis的参数名称
    User updateUserName(Long id, String userName);
    
    // 查询用户，指定MyBatis的参数名称
    List<User> findUsers(User user);
    
    // 删除用户
    int deleteUser(Long id);
}