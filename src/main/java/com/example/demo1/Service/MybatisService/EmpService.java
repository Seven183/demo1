package com.example.demo1.Service.MybatisService;

import com.example.demo1.Dao.MybatisDao.EmpDao;
import com.example.demo1.POJO.MybatisPojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author siguiqiang
 * @create 2019-2-25
 */
@Service
public class EmpService  {

    @Autowired
    public EmpDao empDao = null;


    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public Emp getEmp(long id){
        return empDao.getEmp(id);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public int insertEmp(Emp emp){
        return empDao.insertEmp(emp);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1,propagation = Propagation.REQUIRED)
    public int insertEmpList(Emp emp) {
            return empDao.insertEmp(emp);
    }
}
