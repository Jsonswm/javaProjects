package com.ming.logistics;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
//测试数据库是否链接成功
public class TestDataBase {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Test
//    void mysqlConnection(){
//        //获取user表中有多少条数据
//        Long l = jdbcTemplate.queryForObject("select count(*) from user",Long.class);
//        log.info("{}条数据！",l);
//    }
}
