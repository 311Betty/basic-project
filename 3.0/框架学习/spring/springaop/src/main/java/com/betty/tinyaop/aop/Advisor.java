package com.betty.tinyaop.aop;

import org.aopalliance.aop.Advice;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName Advisor.java
 * @Description TODO
 * @createTime 2020年04月10日 15:51:00
 */
public interface Advisor {
    Advice getAdvice();
}
