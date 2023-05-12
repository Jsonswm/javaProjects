package com.ming.logistics.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.pojo.User;
import com.ming.logistics.service.UserService;
import com.ming.logistics.utils.MD5;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有用户
    @GetMapping
    public List<User> getAll(){
        return userService.list();
    }

    @GetMapping("/getCurrentUser")
    public Result getCurrentUser(String account){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        return Result.success(userService.list(queryWrapper));
    }

    @GetMapping("/getUsers")
    public Result getUsers(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //admin
        queryWrapper.eq("type",1);

        return Result.success(userService.list(queryWrapper));
    }

    @GetMapping("/getDeliver")
    public Result getDeliver(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //deliver
        queryWrapper.eq("type",2);

        return Result.success(userService.list(queryWrapper));
    }

    /**
     * @description: 查询当前订单的配送员
     * @param: id
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/17 10:39
     */
    @GetMapping("/getDeliverById")
    public Result getDeliverById(int id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return Result.success(userService.list(queryWrapper));
    }



    //添加用户
    @PostMapping("/add")
    public Result create(User user){
        //MD5双重加密
        MD5 md5 = new MD5();
        Result result = new Result();

        String pwd = user.getPassword();
        //加密1
        String encodingPwd = md5.encode(pwd);
        //加密2
        String encodedPwd = md5.encode(encodingPwd);
        user.setPassword(encodedPwd);

        return result.success(userService.save(user));
    }

    //根据用户id删除
    @DeleteMapping("/delete")
    public Result deleteById(int id){
        Result result = new Result();
        return result.success(userService.removeById(id));
    }

    @PutMapping
    public Result updateUserInfo(@RequestBody User user){
        MD5 md5 = new MD5();
        String pwd = md5.encode(user.getPassword());
        user.setPassword(pwd);
        return Result.success(userService.updateById(user));
    }
}
