package com.example.demo1.Dao.MybatisDao;

import com.example.demo1.POJO.MybatisPojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author siguiqiang
 * @create 2019-2-25
 */
@Mapper
public interface EmpDao {

    Emp getEmp(long id);
    int insertEmp(Emp emp);
}
