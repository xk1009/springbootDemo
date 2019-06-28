package com.xuke.springboottest.demospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication //springboot 核心启动注解
@MapperScan("com.xuke.springboottest.demospringboot.mapper") //mybatis 扫描mapper接口交给spring管理
@EnableTransactionManagement //开启事务支持 在需要事务的service 添加spring的事务注解
@ServletComponentScan(basePackages = {"com.xuke.springboottest.demospringboot.servlet","com.xuke.springboottest.demospringboot.filter"})//开启servlet,filter包扫描 适用于注解方式
public class DemoSpringbootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        //SpringApplication.run(DemoSpringbootApplication.class, args);

        //关闭springboot 启动log打印
        SpringApplication springApplication = new SpringApplication(DemoSpringbootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);

    }

    /**
     *  springboot打war包
     *  ① 继承SpringBootServletInitializer类
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }




}
