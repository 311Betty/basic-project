package com.betty.tinyaop;

import com.betty.tinyaop.beans.BeanPostProcessor;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BeanInitializeLogger.java
 * @Description TODO
 * @createTime 2020年04月10日 16:07:00
 */
public class BeanInitializeLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " end!");
        return bean;
    }
}

