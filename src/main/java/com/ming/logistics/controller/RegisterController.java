package com.ming.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.pojo.User;
import com.ming.logistics.service.UserService;
import com.ming.logistics.utils.MD5;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result register(@RequestBody User user){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account",user.getAccount()).eq("type",user.getType());
        if (userService.getOne(userQueryWrapper) != null){
            return Result.error(userService.getOne(userQueryWrapper));
        }else {
            MD5 md5 = new MD5();
            String codingPwd = md5.encode(user.getPassword());
            user.setPassword(codingPwd);
            return Result.success(userService.save(user));
        }
    }
}
