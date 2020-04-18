package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.PropertyValue;

import java.lang.reflect.Field;

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
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
 }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

}

