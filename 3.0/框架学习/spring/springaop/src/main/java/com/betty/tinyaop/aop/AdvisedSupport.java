package com.betty.tinyaop.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AdvisedSupport.java
 * @Description TODO
 * @createTime 2020年04月06日 16:12:00
 */

/**
 * 增强目标
 * 拦截器
 */
public class AdvisedSupport {
    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
