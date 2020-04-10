package com.betty.tinyaop.context;

import com.betty.tinyaop.beans.BeanDefinition;
import com.betty.tinyaop.beans.factory.AbstractBeanFactory;
import com.betty.tinyaop.beans.factory.AutowireCapableBeanFactory;
import com.betty.tinyaop.beans.io.ResourceLoader;
import com.betty.tinyaop.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName ClassPathXmlApplicationContext.java
 * @Description TODO
 * @createTime 2020年04月06日 16:52:00
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

public ClassPathXmlApplicationContext(String configLocation) throws Exception{
    this(new AutowireCapableBeanFactory(), configLocation);
}

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }




    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }
}
