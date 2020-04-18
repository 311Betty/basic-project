package com.betty.tinyioc;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BeanDefinition.java
 * @Description TODO
 * @createTime 2020年04月16日 15:33:00
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition() {
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object getBean() {
        return bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
