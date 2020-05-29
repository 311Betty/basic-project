package com.betty.com.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName Task.java
 * @Description TODO
 * @createTime 2020年05月28日 16:41:00
 */

@Component
public class Task {
    //任务一二三
    //线程前后计时
    public static Random random = new Random();

    //@Bean
    @Async("myTaskExecutor")
    public Future<String> taskOne() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("开始One");
        Thread.sleep(new Random().nextInt(10000));
//        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("结束One");

        System.out.println("One执行时间：" + (end - start) + "毫秒");
        return new AsyncResult<>("完成任务一");
    }
    //    @Bean
    @Async("myTaskExecutor")
    public Future<String> taskTwo() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("开始Two");

        Thread.sleep(random.nextInt(10000));

        long end = System.currentTimeMillis();
        System.out.println("结束Two");

        System.out.println("Two执行时间：" + (end - start) + "毫秒");
    return new AsyncResult<>("完成任务二");
}

    //    @Bean
    @Async("myTaskExecutor")
    public Future<String> taskThree() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("开始Three");

        Thread.sleep(random.nextInt(10000));

        long end = System.currentTimeMillis();
        System.out.println("结束Three");

        System.out.println("Three执行时间：" + (end - start) + "毫秒");
    return new AsyncResult<>("完成任务三");
}
}
