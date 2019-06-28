package com.xuke.springboottest.demospringboot.config;

import com.xuke.springboottest.demospringboot.filter.MyselfFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean myselfFilter(){
        FilterRegistrationBean<MyselfFilter> registrationBean = new FilterRegistrationBean<>(new MyselfFilter());
        registrationBean.addUrlPatterns("/*");//过滤 项目上下文后的所有路径
        return registrationBean;
    }
}
