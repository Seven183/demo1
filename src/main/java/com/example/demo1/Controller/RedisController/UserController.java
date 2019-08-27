package com.example.demo1.Controller.RedisController;


import com.example.demo1.POJO.Redispojo.User;
import com.example.demo1.Service.Redisservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/****imports ****/
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService = null;
    
    @RequestMapping("/getUser")
    public User getUser(@RequestBody User user) {

        return userService.getUser(user.getId());
    }
    
    @RequestMapping("/insertUser")
    public User insertUser(@RequestBody User user1) {
        user1.setUserName(user1.getUserName());
        user1.setNote(user1.getNote());
        userService.insertUser(user1);
        return user1;
    }
    
    @RequestMapping("/findUsers")
    public List<User> findUsers(@RequestBody User user) {

        return userService.findUsers(user);
    }
    
    @RequestMapping("/updateUserName")
    public Map<String, Object> updateUserName(@RequestBody User user1) {
        User user = userService.updateUserName(user1.getId(), user1.getUserName());
        boolean flag = user != null;
        String message = flag? "更新成功" : "更新失败";
        return resultMap(flag, message);
    }
    
    @RequestMapping("/deleteUser")
    public Map<String, Object> deleteUser(@RequestBody User user) {
        int result = userService.deleteUser(user.getId());
        boolean flag = result == 1;
        String message = flag? "删除成功" : "删除失败";
        return resultMap(flag, message);
    }
    
    private Map<String, Object> resultMap(boolean success, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", success);
        result.put("message", message);
        return result;
    }
}