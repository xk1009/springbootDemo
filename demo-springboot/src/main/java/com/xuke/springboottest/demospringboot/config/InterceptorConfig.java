package com.xuke.springboottest.demospringboot.config;

import com.xuke.springboottest.demospringboot.interceptor.MyselfInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加一个自定义的拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new MyselfInterceptor());
        String[] patterns = {"/getAllEmployee","/update"};
        interceptor.addPathPatterns(patterns);//添加拦截controller地址
        String[] exclude = {"/index","/hello"};
        interceptor.excludePathPatterns(exclude);//添加放行地址
    }
}
