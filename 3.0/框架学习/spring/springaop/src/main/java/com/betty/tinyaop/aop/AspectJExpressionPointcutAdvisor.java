package com.betty.tinyaop.aop;

import org.aopalliance.aop.Advice;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName AspectJExpressionPointcutAdvisor.java
 * @Description TODO
 * @createTime 2020年04月10日 15:52:00
 */
public class AspectJExpressionPointcutAdvisor implements  PointcutAdvisor{
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }


    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}

