package com.xuke.springboottest.demospringboot.config;

import com.xuke.springboottest.demospringboot.servlet.MyServlet2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean registrationBean(){
        ServletRegistrationBean<MyServlet2> registrationBean = new ServletRegistrationBean<>(new MyServlet2(), "/myServlet2");
        return  registrationBean;
    }
}
