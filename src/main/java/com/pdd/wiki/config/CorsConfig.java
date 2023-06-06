package com.pdd.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    // 跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                // 请求头
                .allowedHeaders(CorsConfiguration.ALL)
                // 请求方法
                .allowedMethods(CorsConfiguration.ALL)
                // 允许凭证 缓存
                .allowCredentials(true)
                .maxAge(3600); // 1小时内不需要再预检（发出OPTIONS请求）
    }
}
