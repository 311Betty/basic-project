package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AbstractBeanFactory.java
 * @Description TODO
 * @createTime 2020年04月16日 15:31:00
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    /**
     * 从定义表中获取bean
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册bean，放入定义表中
     * @param name
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
