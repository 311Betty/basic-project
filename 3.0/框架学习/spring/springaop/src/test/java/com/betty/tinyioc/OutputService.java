package com.betty.tinyioc;

import org.junit.Assert;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName OutputService.java
 * @Description TODO
 * @createTime 2020年04月18日 11:10:00
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}

