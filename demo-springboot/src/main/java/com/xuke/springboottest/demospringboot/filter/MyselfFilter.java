package com.xuke.springboottest.demospringboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 */
public class MyselfFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("经过过滤器 过滤了！！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
