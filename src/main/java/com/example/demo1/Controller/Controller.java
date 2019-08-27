package com.example.demo1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/hello")
    public String hello(){

        return  "hello Wroldhdfgdgd" ;
    }

}
