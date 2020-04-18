package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.HelloWorldService;
import com.betty.tinyioc.PropertyValue;
import com.betty.tinyioc.PropertyValues;
import com.betty.tinyioc.context.AbstractApplicationContext;
import com.betty.tinyioc.io.ResourceLoader;
import com.betty.tinyioc.xml.XmlBeanDefinitionReader;
import com.sun.javafx.property.adapter.JavaBeanPropertyBuilderHelper;
import org.junit.Test;
import sun.nio.fs.AbstractFileTypeDetector;

import java.util.Map;

public class BeanFactoryTest {
//    @Test
//    public void test() throws Exception {
//        // 1.初始化beanfactory
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//
//        // 2.bean定义
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassName("com.betty.tinyioc.HelloWorldService");
//
//        //3.设置属性
//        PropertyValues propertyValues = new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
//        beanDefinition.setPropertyValues(propertyValues);
//
//        //4.生成bean
//        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
//
//        //5..获取bean
//        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
//        helloWorldService.helloWorld();
//
//    }
    @Test
    public void testLazy() throws   Exception{
        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        //2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
public void testPreInstantiate() throws Exception{
        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        //2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
        //3.初始化bean
        beanFactory.preInstantiateSingletons();

        //4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
