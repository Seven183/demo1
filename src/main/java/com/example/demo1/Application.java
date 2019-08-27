package com.example.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;

//扫描dao包，
// 另一种方法是在dao上加上@mapper注解也可以
//限定加载Repository注解的类
@MapperScan(basePackages = "com.example.demo1.Dao")
        //,annotationClass = Repository.class)
@SpringBootApplication(scanBasePackages = {"com.example.demo1"})
//扫描实体类的包
@EntityScan(basePackages = "com.example.demo1.POJO")
//使用注解驱动缓存机制
@EnableCaching
public class Application extends SpringBootServletInitializer {


    //这个是为了初始化springBoot用的，方便在外部的Tomcat中运行
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
