package com.unfrost.common.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 10:53
 */
@EnableScheduling
@Configuration
@EnableAsync
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**").addResourceLocations("file:" + warehouseResourceProperties.getImagesAddress());
//        registry.addResourceHandler("/videos/**").addResourceLocations("file:" + warehouseResourceProperties.getVideoAddress());
//        registry.addResourceHandler("/pdfs/**").addResourceLocations("file:" + warehouseResourceProperties.getPdfAddress());
        registry.addResourceHandler("/log/**").addResourceLocations("file:" + "./log/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .exposedHeaders()
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(true);
    }
}
