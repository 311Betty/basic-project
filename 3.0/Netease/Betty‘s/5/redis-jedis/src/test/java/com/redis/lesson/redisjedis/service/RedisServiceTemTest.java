package com.redis.lesson.redisjedis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceTemTest {

    @Autowired
    private RedisServiceTem redisServiceTem;

//存值
    @Test
    public void set() {
        redisServiceTem.set("name", "1");
    }
//取值
    @Test
    public void get() {
        System.out.println(redisServiceTem.get("name").toString());

    }
//删值
    @Test
    public void delete() {
        System.out.println(redisServiceTem.delete("name"));

    }
}
