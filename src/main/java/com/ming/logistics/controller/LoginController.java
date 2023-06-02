package com.ming.logistics.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.config.RedisConfig;
import com.ming.logistics.pojo.User;
import com.ming.logistics.service.UserService;
import com.ming.logistics.utils.MD5;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    Jedis jedis = RedisConfig.getJedis();




    /**
     * @description: * @param user
     * @return: com.ming.logistics.utils.Result
     * @author: swm
     * @time: 2023/3/16 0:25
     */
    @PostMapping
    public Result login(@RequestBody User user) {
        String preLoginTime = "";

        MD5 md5 = new MD5();
        String CodePwd = md5.encode(user.getPassword());

        //条件构造器,
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //eq:=  将输入的用户名和密码与数据库中的值对比
        queryWrapper.eq("account", user.getAccount()).eq("password", CodePwd).eq("type", user.getType());


        user = userService.getOne(queryWrapper);
        if (user != null) {
            String key = "now_login_time_" + user.getAccount();
            System.out.println("111" + userService.getOne(queryWrapper));
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            user.setLastLoginTime(format);

            jedis.set(key, format);

            //JWT，设置登录过期时间，将数据存到token中
            //生成token
            HashMap<String, Object> map = new HashMap<>();
            //使用默认时区和区域设置获取日历
            Calendar instance = Calendar.getInstance();
            //有效时间为60分钟
            instance.add(Calendar.MINUTE, 60);
            String token = JWT.create()
                    .withAudience(String.valueOf(user.getAccount()), user.getPassword(), user.getLastLoginTime(), user.getId(), user.getType())//存数据
                    .withExpiresAt(instance.getTime())//设置过期时间
                    .sign(Algorithm.HMAC256("hmac256"));
            userService.updateById(user);
            return Result.success(token);
        } else {
            return Result.error();
        }

    }


}
