package com.ming.logistics;

import com.ming.logistics.pojo.User;
import com.ming.logistics.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    UserService userService;

    @Test
    void test(){
        List<User> list = userService.list();
        System.out.println(list);
    }
}
