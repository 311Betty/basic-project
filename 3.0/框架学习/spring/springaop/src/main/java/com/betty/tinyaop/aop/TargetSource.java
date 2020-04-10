package com.betty.tinyaop.aop;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName TargetSource.java
 * @Description TODO
 * @createTime 2020年04月06日 16:48:00
 */

public class TargetSource {

    private Class targetClass;

    private Object target;

    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}

