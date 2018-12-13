package com.example.demo1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class Controller {
        @RequestMapping(value = "/hello")
        public String hello(){
            return  "hello Wroldhdfgdgd" ;
        }

}
