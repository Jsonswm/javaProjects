package com.ming.logistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir");
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + path + "/src/main/resources/static/goodsImages/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}