package com.betty.tinyioc;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BeanPostProcessor.java
 * @Description TODO
 * @createTime 2020年04月18日 14:44:00
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;
    Object postProcessAfterInitialization(Object bean,String beanName) throws Exception;

}
