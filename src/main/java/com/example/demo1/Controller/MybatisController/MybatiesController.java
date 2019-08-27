package com.example.demo1.Controller.MybatisController;


import com.alibaba.fastjson.JSON;
import com.example.demo1.POJO.MybatisPojo.Emp;
import com.example.demo1.Service.MybatisService.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author siguiqiang
 * @create 2019-2-25
 */
@RestController
public class MybatiesController {

    @Autowired
    public EmpService empService;

    @GetMapping("/hello")
    public String Hello(){
        return "hffhh";
    }


    @GetMapping("/getEmp")
    public Emp getEmp(long id){
        return empService.getEmp(id);
    }

    @PostMapping("/insertEmp")
    public int insertEmp(@RequestBody Emp emp){
        return empService.insertEmp(emp);
    }

    @PostMapping("/insertEmpList")
    public Object insertEmpList(@RequestBody List<Emp> emp){
        System.out.println(JSON.toJSONString(emp));
        for ( Emp  s : emp) {
            List list =new ArrayList();
            list.add(emp);
            int insert= empService.insertEmpList(s);
            Map map = new HashMap();
            map.put("success",insert>0);
            map.put("emp",list);
        }
        return "ok";
    }

}
