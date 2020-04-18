package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.HelloWorldService;
import com.betty.tinyioc.PropertyValue;
import com.betty.tinyioc.PropertyValues;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.betty.tinyioc.HelloWorldService");

        //3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        //4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        //5..获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
