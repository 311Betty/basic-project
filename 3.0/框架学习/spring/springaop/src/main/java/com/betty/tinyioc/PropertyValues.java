package com.betty.tinyioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName PropertyValues.java
 * @Description TODO
 * @createTime 2020年04月17日 10:11:00
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        //TODO:这里可以对于重复propertyName进行判断，直接用list没法做到
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return  this.propertyValueList;
    }
}
