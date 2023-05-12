package com.ming.logistics;

import com.ming.logistics.mapper.UserMapper;
import com.ming.logistics.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test1 {

    @Autowired
    UserMapper userMapper;

    @Test
    public void select(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

}
