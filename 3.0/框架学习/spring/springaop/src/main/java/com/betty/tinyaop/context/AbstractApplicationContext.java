package com.betty.tinyaop.context;

import com.betty.tinyaop.beans.factory.AbstractBeanFactory;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AbstractApplicationContext.java
 * @Description TODO
 * @createTime 2020年04月06日 16:49:00
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
