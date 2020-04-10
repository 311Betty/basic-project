package com.betty.tinyaop.context;

import com.betty.tinyaop.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName ApplicationContextTest.java
 * @Description TODO
 * @createTime 2020年04月08日 14:56:00
 */

public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
