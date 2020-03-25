package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.health.service.UserService;
import lombok.extern.slf4j.Slf4j;


/**
 * @author:yixiaolan
 * @date:Created in 2020/3/24
 * @description:
 * @version:1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String username, String password) {
        //System.out.println("service_provide...u:"+username+" p:"+password);
        log.debug("u:{},p:{}",username,password);
        if("admin".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }
}