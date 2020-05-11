package com.redis.lesson.redisjedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName RedisConfig.java
 * @Description TODO
 * @createTime 2020年05月11日 11:25:00
 */
@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.maxTotal}")
    private int maxTotal;
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.minIdle}")
    private int minIdle;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.maxWait}")
    private long maxWait;

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    //连接池阻塞最大等待时间
            jedisPoolConfig.setMaxWaitMillis(maxWait);
    //连接池最大空闲连接数
            jedisPoolConfig.setMaxIdle(maxIdle);
    //连接池最小空闲连接数
            jedisPoolConfig.setMinIdle(maxIdle);
    //连接池最大链接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        System.out.println(jedisPool.getResource().exists("name"));
        return jedisPool;
    }
}


