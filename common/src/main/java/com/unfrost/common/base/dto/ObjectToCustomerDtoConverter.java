package com.unfrost.common.base.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * @author Curtain
 * @date 2019/11/14 12:22
 * @deprecated DTO 转换将被废弃
 */
public class ObjectToCustomerDtoConverter<T extends BaseDTO>
        implements Converter<Object, T> {
    private final static Logger log = LoggerFactory.getLogger(ObjectToCustomerDtoConverter.class);
    private Class<T> target;

    public ObjectToCustomerDtoConverter(Class<T> target) {
        this.target = target;
    }

    @Override
    public T convert(Object from) {
        T rs;
        try {
            rs = (T) Class.forName(target.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("无法生成目标类型实例");

        }
        Map<String, Object> map = (Map) from;

        setFieldValue(rs, map);

        return rs;

    }


    /**
     * set属性的值到Bean
     *
     * @param rs       目标类
     * @param valueMap 数据集
     */
    private static void setFieldValue(Object rs, Map<String, Object> valueMap) {
        Class<?> cls = rs.getClass();
        String value;
        for (String key : valueMap.keySet()) {
            Field field = null;
            Object o = valueMap.get(key);
            value = o == null ? null : o.toString();

            try {
                field = cls.getDeclaredField(key);
            } catch (NoSuchFieldException e) {
//                修改后可以将未知属性不赋值
//                e.printStackTrace();
                log.info(String.format("没有找到匹配的属性:[%s]", key));
//                throw new RuntimeException("没有找到匹配属性:" + key);
            }
            if (Objects.nonNull(field)) {
                Class<?> type = field.getType();
                Object data;
                // TODO: 2020-03-26 增加异常处理  解析失败。
                data = type.equals(String.class) ? value :
                        type.equals(Integer.class) ? (value == null ? 0 : Integer.valueOf(value)) :
                                type.equals(int.class) ? (value == null ? 0 : Integer.valueOf(value)) :
                                        type.equals(long.class) ? (value == null ? 0 : Long.valueOf(value)) :
                                                type.equals(Long.class) ? (value == null ? 0 : Long.valueOf(value)) :
                                                        Enum.class.isAssignableFrom(type) ? (value != null ? Enum.valueOf((Class<Enum>) type, value) : null) :
                                                                type.equals(Double.class) ? (value == null ? 0 : Double.valueOf(value)) :
                                                                        null;
                Method fieldSetMet = getSetMethod(cls, key);
                try {
                    fieldSetMet.invoke(rs, data);
                } catch (Exception e) {
                    //                修改后可以将未知属性不赋值
//                e.printStackTrace();
                    log.info(String.format("没有找到匹配的属性:[%s]", key));
//                throw new RuntimeException("没有找到匹配属性:" + key);
                }
            }
        }


    }

    /**
     * 获取目标set方法
     *
     * @param objectClass 目标类
     * @param fieldName   属性名
     * @return
     */
    private static Method getSetMethod(Class objectClass, String fieldName) {
        try {
            Class[] parameterTypes = new Class[1];
            Field field = objectClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            StringBuilder sb = new StringBuilder();
            sb.append("set");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            return objectClass.getMethod(sb.toString(), parameterTypes);
        } catch (Exception e) {
            //            e.printStackTrace();
            log.info("没有找到目标类 属性" + fieldName + "的set方法");
            return null;
            //throw new RuntimeException("没有找到目标类 属性" + fieldName + "set方法");
        }
    }

}