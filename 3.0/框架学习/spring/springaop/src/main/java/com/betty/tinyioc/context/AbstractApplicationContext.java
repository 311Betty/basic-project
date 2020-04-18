package com.betty.tinyioc.context;

import com.betty.tinyioc.factory.AbstractBeanFactory;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AbstractApplicationContext.java
 * @Description TODO
 * @createTime 2020年04月18日 11:16:00
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void refresh() throws Exception{}

    @Override
    public Object getBean(String name) throws Exception{
        return beanFactory.getBean(name);
    }
}
