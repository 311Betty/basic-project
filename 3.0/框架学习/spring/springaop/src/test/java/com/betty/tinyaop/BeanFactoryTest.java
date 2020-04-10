package com.betty.tinyaop;

import com.betty.tinyaop.beans.BeanDefinition;
import com.betty.tinyaop.beans.factory.AbstractBeanFactory;
import com.betty.tinyaop.beans.factory.AutowireCapableBeanFactory;
import com.betty.tinyaop.beans.io.ResourceLoader;
import com.betty.tinyaop.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BeanFactoryTest.java
 * @Description TODO
 * @createTime 2020年04月08日 15:00:00
 */

public class BeanFactoryTest {
   @Test
    public void testLazy()throws Exception {
       //1.读取配置
       XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
       xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
       //2.初始化BeanFactory并注册bean
       AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
       for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
           beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
       }

       // 3.获取bean
       HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
       helloWorldService.helloWorld();
   }
@Test
    public void testPreInstantiate() throws Exception {
    //1.读取配置
    XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
    xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
    //2.初始化BeanFactory并注册bean
    AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
    for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
        beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
    }



    //3.获取bean
    beanFactory.preInstantiateSingletons();

    //4.获取bean
    HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
    helloWorldService.helloWorld();
}
}
