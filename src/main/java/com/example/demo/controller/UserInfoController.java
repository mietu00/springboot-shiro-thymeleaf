package com.example.demo.controller;

/**
 * Created by Administrator on 2018/4/10.
 */
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {




    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    public String userInfo(){
        return "/user";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @ResponseBody
    @RequiresPermissions("system:userInfo:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @ResponseBody
    @RequiresPermissions("system:userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}
