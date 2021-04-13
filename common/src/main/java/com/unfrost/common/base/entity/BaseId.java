package com.unfrost.common.base.entity;

import cn.hutool.core.util.StrUtil;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * 基础Id
 *
 * @author Shimizu
 * @description
 * @date 2021-04-07 14:45
 */
@MappedSuperclass
public class BaseId implements Serializable {
    @Id
    @GenericGenerator(name = "baseIdGenerator", strategy = "com.unfrost.common.util.CustomUUIDGenerator")
    @GeneratedValue(generator = "baseIdGenerator")
    @Column(length = 40)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (ObjectUtils.isEmpty(id)) {
            throw new RuntimeException("Id 不能为空");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId baseId = (BaseId) o;
        return Objects.equals(id, baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public BaseId(String id) {
        this.id = id;
    }

    public BaseId() {
        if (this.id == null || "".equals(this.id))
            this.id = UUID.randomUUID().toString();
    }
}
