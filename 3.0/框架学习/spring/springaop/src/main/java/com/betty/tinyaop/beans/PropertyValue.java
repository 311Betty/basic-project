package com.betty.tinyaop.beans;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName PropertyValue.java
 * @Description TODO 用于bean的属性注入
 * @createTime 2020年04月07日 17:27:00
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
