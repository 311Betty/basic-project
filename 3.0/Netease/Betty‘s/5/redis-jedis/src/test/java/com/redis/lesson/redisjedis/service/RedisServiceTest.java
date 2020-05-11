package com.redis.lesson.redisjedis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.sun.deploy.cache.Cache.exists;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RedisServiceTest {
    @Autowired
    RedisService redisService;

    @Test
    void testSet() {
        String result= redisService.set("name1", "22",6);
        System.out.println(result);
        assertEquals(result, "OK");
    }

    @Test
    void testExists() {
        System.out.println(redisService.exists("name"));
        assertEquals(redisService.exists("name"),true);
    }
}
