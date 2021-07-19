package com.vue.contorller;

import com.alibaba.fastjson.JSON;
import com.vue.bean.Admin;
import com.vue.serivce.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(value = "http://localhost:9528")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestBody Admin admin){
        System.out.println(admin);
        boolean checkLogin = loginService.checkLogin(admin);
        System.err.println(checkLogin);
        return  checkLogin ? "ok":"error";
    }

    @RequestMapping("/get")
    public String getById(@PathVariable Integer id){
        Admin id1 = loginService.getById(id);
        String jsonString = JSON.toJSONString(id1);
        return  jsonString;
    }
}
