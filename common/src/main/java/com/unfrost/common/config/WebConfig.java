package com.unfrost.common.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.unfrost.common.properties.CommonFileProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
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
    private final CommonFileProperties commonFileProperties;

    public WebConfig(CommonFileProperties commonFileProperties) {
        this.commonFileProperties = commonFileProperties;
        commonFileProperties.mkdirs();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + commonFileProperties.getImage());
        registry.addResourceHandler("/videos/**").addResourceLocations("file:" + commonFileProperties.getVideo());
        registry.addResourceHandler("/files/**").addResourceLocations("file:" + commonFileProperties.getFile());
        registry.addResourceHandler("/log/**").addResourceLocations("file:" + "./log/");
    }

    /**
     * 开启跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
//                .exposedHeaders()
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                //是否允许证书
                .allowCredentials(true)
                // 设置允许跨域请求的头
                .allowedHeaders("*")
                // 设置允许的方法
                .allowedMethods("*");
        // 设置允许跨域请求的域名
//                .allowedOrigins("*")

    }

    /**
     * 解决了 JPA项目,查询失败,Could not write JSON: failed to lazily initialize a collection of role
     *
     * @return
     */
    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }


}
