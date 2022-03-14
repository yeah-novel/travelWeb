package com.example.travel.config;

import com.example.travel.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    /*@Autowired
    private LoginInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(loginHandlerInterceptor);
        // 拦截路径
        ir.addPathPatterns("/*");
        // 不拦截路径
        List<String> irs = new ArrayList<String>();
        irs.add("/api/*");
        irs.add("/wechat/*");
        irs.add("/oauth");
        ir.excludePathPatterns(irs);
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry

                .addResourceHandler("/static/**")

                .addResourceLocations("classpath:/static/*.html");
    }

}
