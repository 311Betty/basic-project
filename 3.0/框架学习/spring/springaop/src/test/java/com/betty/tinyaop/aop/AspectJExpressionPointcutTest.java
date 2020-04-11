package com.betty.tinyaop.aop;

import com.betty.tinyaop.HelloWorldService;
import com.betty.tinyaop.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AspectJExpressionPointcutTest {


    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.betty.tinyaop.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.betty.tinyaop.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
