package com.betty.com.schedule.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName Schedule.java
 * @Description TODO
 * @createTime 2020年05月28日 16:29:00
 */
@Component
public class Schedule {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
@Scheduled(fixedRate = 5000)
    public void processSchedule() {
    System.out.println("定时器执行，当前时间为"+ dateFormat.format(new Date()));
    }
}
