package com.betty.tinyaop.aop;

import jdk.nashorn.api.scripting.ClassFilter;

import java.lang.reflect.Method;

public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);

}
