package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;

public interface BeanFactory {
    /**
     * 获取bean
     * @param name
     * @return
     */
    Object getBean(String name) throws Exception;

//    /**
//     * 注册bean
//     * @param name
//     * @param beanDefinition
//     */
//    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
