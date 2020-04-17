package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AutowireCapableBeanFactory.java
 * @Description TODO
 * @createTime 2020年04月16日 15:32:00
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}

