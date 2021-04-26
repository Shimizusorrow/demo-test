package com.unfrost.common.base.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-26 11:50
 */
@Configuration
public class DtoConverterProvider {
    @Bean(name = "DtoConverterProvider.provide")
    public void provide() {
        GenericConversionService sharedInstance = (GenericConversionService) DefaultConversionService.getSharedInstance();
        sharedInstance.addConverterFactory(new DtoConverterFactory());
    }
}
