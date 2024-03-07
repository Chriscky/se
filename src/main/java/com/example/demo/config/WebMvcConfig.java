package com.example.demo.config;

import com.example.demo.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /*
     * 原本直接使用new JwtInterceptor传入的方式会导致后面的请求空指针,这里必须注入WebMvcConfig和手动构建jwtInterceptor
     * by riruleben
     * */
    private final JwtInterceptor jwtInterceptor;

    @Autowired
    public WebMvcConfig(JwtInterceptor jwtInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
    }

    /*
    * 处理跨域请求放行
    * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
//                .allowedHeaders("X-Set-Cookie", "Origin", "Accept", "Content-Type", "Authorization")
                .allowedHeaders("*")
                .exposedHeaders("X-Set-Cookie")
                .allowedMethods("GET", "PUT", "DELETE", "OPTIONS", "POST", "HEAD")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/api/**") // 拦截 /api/ 下的所有请求
//                .excludePathPatterns("/api/v1/user/login") // 排除 /api/v1/login 接口
//                .excludePathPatterns("/api/v1/user/register") // 排除 /api/v1/register 接口
////                .excludePathPatterns("/api/v1/upload") // 排除 /api/v1/upload 接口
//                .excludePathPatterns("/api/v1/isRegistrationEnabled"); // 排除 /api/v1/isRegistrationEnabled 接口
    }
}