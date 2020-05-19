package com.betty.lesson.lessonfilter.config;

import com.betty.lesson.lessonfilter.filter.MyFilter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName FilterRegister.java
 * @Description TODO
 * @createTime 2020年05月18日 16:17:00
 */
@Configuration
public class FilterRegister {
    private FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

    @Bean
    public MyFilter getMyFilter() {
        return new MyFilter();

    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        MyFilter myFilter = getMyFilter();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.addUrlPatterns("/api/*" );
        filterRegistrationBean.setName("myFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
