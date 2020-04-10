package com.betty.tinyaop;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName HelloWorldServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月08日 15:00:00
 */
public class HelloWorldServiceImpl implements  HelloWorldService {
private String text;
private OutputService outputService;
    @Override
    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
