package com.betty.tinyaop.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();

}
