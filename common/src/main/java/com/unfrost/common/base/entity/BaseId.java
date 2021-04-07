package com.unfrost.common.base.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * 基础Id
 *
 * @author Shimizu
 * @description
 * @date 2021-04-07 14:45
 */
@MappedSuperclass
public abstract class BaseId {
    @Id
    @GenericGenerator(name = "baseIdGenerator", strategy = "uuid")
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
}
