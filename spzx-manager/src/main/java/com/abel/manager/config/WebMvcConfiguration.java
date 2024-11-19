package com.abel.manager.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.abel.manager.interceptor.AuthInterceptor;

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    private final AuthConfiguration authConfiguration;

    public WebMvcConfiguration(AuthInterceptor authInterceptor, AuthConfiguration authConfiguration) {
        this.authInterceptor = authInterceptor;
        this.authConfiguration = authConfiguration;
    }

    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(authConfiguration.getExcludeUrls());
    }

}
