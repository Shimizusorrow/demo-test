package com.unfrost.core.repo;

import com.unfrost.core.domain.FileMapper;
import com.unfrost.core.enums.FileEnum;
import com.unfrost.common.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 14:44
 */
public interface FileMapperRepo extends JpaRepository<FileMapper, String> {
    /**
     * 判断是否存在同一类型的名称文件
     *
     * @param realName
     * @param fileEnum
     * @return
     */
    boolean existsByRealNameAndCategory(String realName, FileEnum fileEnum);

    /**
     * 通过文件原来的名称和文件类型查询文件
     *
     * @param realName 文件原来的名称
     * @param fileEnum 文件类型
     * @return
     */
    FileMapper findByRealNameAndCategory(String realName, FileEnum fileEnum);

    /**
     * 通过Id 查询文件
     *
     * @param id 文件Id
     * @return
     */
    default FileMapper findByIdThrow(String id) {
        return findById(id).orElseThrow(() -> new BusinessException("文件不存在!"));
    }

    /**
     * 获得文件的映射名称
     * @param id 文件Id
     * @return
     */
    default String findFileMapperNameById(String id) {
        return findByIdThrow(id).getMapperName();
    }
}
