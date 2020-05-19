package com.betty.lesson.myinterceptor.config;

import com.betty.lesson.myinterceptor.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName InterceptorConfig.java
 * @Description TODO
 * @createTime 2020年05月19日 15:22:00
 */
@Configuration

public class InterceptorConfig implements WebMvcConfigurer {
    @Value("${open.url}")
    private String openUrl;

    @Bean
    public MyInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/api/**").excludePathPatterns(openUrl);
    }
}
