package com.example.tmp.controller;


import com.example.tmp.entity.User;
import com.example.tmp.mapper.UserMapper;
import com.example.tmp.result.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author hbw
 * @since 2026-02-18
 */
@RestController
@RequestMapping("/user")
public class UserController {
      @Autowired
      private UserMapper userTableMapper;


      Gson gson = new GsonBuilder().serializeNulls().create();
      Result result = new Result();
      @PostMapping("/login")
      public Result login(String json){
            User user=null;
            User user1=null;
            try{
                  user=gson.fromJson(json,User.class);

            }catch (Exception e){
                  e.printStackTrace();
            }
            user1=userTableMapper.getByUserName(user.getName());
            //存在该账户
            if(user1!=null){
                  //密码正确
                  if(user1.getIdNumber().equals(user.getIdNumber())){
                        result.setSuccess("登录成功！",gson.toJson(user1));

                  }else{//密码错误

                        result.setInfo("用户名或密码错误！",null);
                  }
            }else{//不存在该账户
                  result.setInfo("该账号不存在！",null);
            }
            return result;
      }

}
