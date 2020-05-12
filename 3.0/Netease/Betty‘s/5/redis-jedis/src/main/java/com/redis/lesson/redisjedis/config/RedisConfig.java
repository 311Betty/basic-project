package com.redis.lesson.redisjedis.config;

import com.redis.lesson.redisjedis.serializer.MyStringRedisSerializer;
import jdk.management.resource.ResourceContextFactory;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    @Bean
    public RedisTemplate<String ,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownException {
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate();
        objectObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        MyStringRedisSerializer myStringRedisSerializer = new MyStringRedisSerializer();
        objectObjectRedisTemplate.setKeySerializer(stringRedisSerializer);
        objectObjectRedisTemplate.setValueSerializer(myStringRedisSerializer);
        objectObjectRedisTemplate.setHashKeySerializer(stringRedisSerializer);
        objectObjectRedisTemplate.setHashValueSerializer(myStringRedisSerializer);
        return objectObjectRedisTemplate;
        //重写template两种序列化方式 key、hashkey
    }
}


