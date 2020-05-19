package com.betty.lesson.lessonfilter.filter;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName MyFilter.java
 * @Description TODO
 * @createTime 2020年05月18日 11:06:00
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = "/api/*", filterName = "myFilter")
//@Order(1)
public class MyFilter implements Filter {
    @Value("${open.url}")
    private String openurl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
//        System.out.println(requestURI+""+method+ "过滤器内部~");
        System.out.println("拦截了请求" + requestURI);
        //判断开放端口
        PathMatcher matcher = new AntPathMatcher();
        System.out.println(requestURI + "|" + openurl + "|" + matcher.match(openurl,requestURI));
        if (matcher.match(openurl,requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            //判断token是否为空
            String token = request.getHeader("token");
//            if (token == null) {
            if(StringUtils.isEmpty(token)){

                servletRequest.getRequestDispatcher("/open/unlogin").forward(servletRequest, servletResponse);

            }
            filterChain.doFilter(servletRequest, servletResponse);

        }


    }
}
