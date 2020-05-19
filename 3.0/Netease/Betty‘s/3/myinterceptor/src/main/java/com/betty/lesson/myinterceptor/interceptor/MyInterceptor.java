package com.betty.lesson.myinterceptor.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName MyInterceptor.java
 * @Description TODO
 * @createTime 2020年05月19日 15:24:00
 */
public class MyInterceptor implements HandlerInterceptor {
    @Value("${open.url}")
    private String openUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求处理前");
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        System.out.println("拦截到了请求："+requestURI+"拦截到了方法："+method);
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            request.getRequestDispatcher("/api/open/unlogin").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理后，渲染视图前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("所有请求处理完成，渲染视图后");
    }
}
