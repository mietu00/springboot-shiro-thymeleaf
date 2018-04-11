package com.example.demo.service.impl;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoRepository;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/10.
 */
@Service
public class UserInfoServiceimpl implements UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;

    @Transactional(readOnly=true)
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

}
