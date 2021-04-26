package com.unfrost.common.base.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author Administrator
 */
public class DtoConverterFactory implements ConverterFactory<Object, BaseDTO> {

    @Override
    public <T extends BaseDTO> Converter<Object, T> getConverter(Class<T> targetType) {
        return new ObjectToBaseDtoConverter<>(targetType);
    }
}
