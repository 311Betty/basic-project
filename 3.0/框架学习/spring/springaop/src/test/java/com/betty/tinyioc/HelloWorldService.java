package com.betty.tinyioc;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName HelloWorldService.java
 * @Description TODO
 * @createTime 2020年04月16日 15:44:00
 */
public class HelloWorldService {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    /**
     * 测试方法
     */
    public void helloWorld(){
        System.out.println(text);
    }

}
