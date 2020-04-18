package com.betty.tinyioc.context;

import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.factory.AbstractBeanFactory;
import com.betty.tinyioc.factory.AutowireCapableBeanFactory;
import com.betty.tinyioc.io.ResourceLoader;
import com.betty.tinyioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName ClassPathXmlApplicationContext.java
 * @Description TODO
 * @createTime 2020年04月18日 11:20:00
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext( String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();

    }
    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());

        }
    }
}
