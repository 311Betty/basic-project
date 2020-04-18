package com.betty.tinyioc;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName PropertyValue.java
 * @Description TODO
 * @createTime 2020年04月17日 10:09:00
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
