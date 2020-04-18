package com.betty.tinyioc.factory;

import com.betty.tinyioc.BeanDefinition;
import com.betty.tinyioc.BeanReference;
import com.betty.tinyioc.PropertyValue;

import javax.xml.bind.ValidationEvent;
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
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
 }

    /**
     * 创建beandefinition实例
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    @Override
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     *初始化时，解析将真实bean注入
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
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

