package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.common.MessageConst;
import com.itheima.health.entity.Result;
import com.itheima.health.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.health.common.MessageConst;

/**
 * @author:yixiaolan
 * @date:Created in 2020/3/24
 * @description:
 * @version:1.0
 */
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/login.do")
    public Result login(String username, String password){
        System.out.println("oms backend,user:"+username+" ,password:"+password);
        if(userService.login(username,password)){
            System.out.println("login ok!!!");
            return new Result(true, MessageConst.ACTION_SUCCESS);
        }else{
            System.out.println("login fail");
            return new Result(false,MessageConst.ACTION_FAIL);
        }
    }
}