package com.betty.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName WebApplication.java
 * @Description TODO
 * @createTime 2020年05月21日 14:48:00
 */
@SpringBootApplication(scanBasePackages = "com.betty.lesson")
@MapperScan("com.betty.lesson.mapper")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
