package com.example.demo.service;

import com.example.demo.bean.UserInfo;

/**
 * Created by Administrator on 2018/4/10.
 */


public interface UserInfoService {

    public UserInfo findByUsername(String username);

}
