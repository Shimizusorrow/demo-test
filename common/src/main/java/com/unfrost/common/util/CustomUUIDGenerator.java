package com.unfrost.common.util;

import com.unfrost.common.base.entity.BaseId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * 自定义UUID 生成器
 *
 * @author Shimizu
 * @description
 * @date 2021-04-13 14:44
 */
public class CustomUUIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        if (o instanceof BaseId) {
            String id = ((BaseId) o).getId();
            if (id == null || "".equals(id)) {
                id = generateUUID();
            }
            return id;
        }
        return generateUUID();
    }

    /**
     * 生成随机的UUID
     *
     * @return
     */
    private String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
