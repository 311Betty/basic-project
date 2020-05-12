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

    @Test
    public void delete() {
        System.out.println(redisServiceTem.delete("name"));

    }

    @Test
    public void set() {
        redisServiceTem.set("name", "1");
    }

    @Test
    public void get() {
        System.out.println(redisServiceTem.get("name").toString());

    }
}
