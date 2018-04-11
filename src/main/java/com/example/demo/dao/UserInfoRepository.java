package com.example.demo.dao;

import com.example.demo.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2018/4/10.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    /** 通过username查找用户信息 **/
    public UserInfo findByUsername(String username);

}
