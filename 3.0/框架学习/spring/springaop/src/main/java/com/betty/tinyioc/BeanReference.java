package com.betty.tinyioc;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BeanReference.java
 * @Description TODO
 * @createTime 2020年04月18日 10:18:00
 */
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
