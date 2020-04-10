package com.betty.tinyaop.beans.factory;

import com.betty.tinyaop.BeanReference;
import com.betty.tinyaop.beans.BeanDefinition;
import com.betty.tinyaop.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AutowireCapableBeanFactory.java
 * @Description TODO
 * @createTime 2020年04月07日 14:42:00
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}

