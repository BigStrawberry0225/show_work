//package com.codercm.bk.config;
//
//import com.codercm.bk.interceptor.LoginInterceptor;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//将拦截器配置到项目中
//@SpringBootConfiguration
//public class MyWebConfigurer implements WebMvcConfigurer {
//
//    @Bean
//    public LoginInterceptor getLoginInterceptor() {
//        return new LoginInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
//    }
//}
