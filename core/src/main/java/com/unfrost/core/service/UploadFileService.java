package com.unfrost.core.service;

import com.unfrost.common.constant.PunctuationConstants;
import com.unfrost.core.enums.FileEnum;
import com.unfrost.core.event.UpLoadFileEvent;
import com.unfrost.common.exception.BusinessException;
import com.unfrost.common.properties.CommonFileProperties;
import com.unfrost.core.repo.FileMapperRepo;
import com.unfrost.common.util.UploadUtils;
import com.unfrost.core.domain.FileMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

/**
 * 文件上传服务
 *
 * @author Shimizu
 * @description 文件上传服务
 * @date 2021-04-14 14:52
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UploadFileService {
    private final CommonFileProperties commonFileProperties;
    private final FileMapperRepo fileMapperRepo;
    private final ApplicationEventPublisher publisher;

    /**
     * 上传图片
     *
     * @param file 文件
     * @return 上传的文件ID
     */
    public String uploadImage(MultipartFile file) {
        return uploadFile(file, FileEnum.IMAGE);
    }

    /**
     * 上传视屏
     *
     * @param file 文件
     * @return 上传的文件ID
     */
    public String uploadVideo(MultipartFile file) {
        return uploadFile(file, FileEnum.VIDEO);
    }

    /**
     * 上传普通文件
     *
     * @param file 文件
     * @return 上传的文件ID
     */
    public String uploadFile(MultipartFile file) {
        return uploadFile(file, FileEnum.FILE);
    }

    /**
     * 上传文件
     *
     * @param file     需要上传的文件
     * @param category 文件的类型
     * @return 上传的文件Id
     */
    private String uploadFile(MultipartFile file, FileEnum category) {
        String filename = getOriginalFilename(file);
        String mapperName = getMapperName(filename, getUUIDName());
        FileMapper mapper = new FileMapper(UUID.randomUUID().toString(), filename, mapperName, category);
        publisher.publishEvent(new UpLoadFileEvent(mapper));
        UploadUtils.upLoadFile(file, getFilePath(category), mapperName);
        return mapper.getId();
    }

    /**
     * 获取映射的名称
     *
     * @param filename 源文件名称
     * @param uuidName 唯一名称
     * @return String 映射名称
     */
    private String getMapperName(String filename, String uuidName) {
        int suffix = filename.lastIndexOf(PunctuationConstants.SUFFIX);
        if (suffix == -1) {
            throw new BusinessException("文件必须附带后缀名");
        }
        return uuidName + filename.substring(suffix);
    }

    /**
     * 获得存放文件的位置
     *
     * @param category 文件类型
     * @return String 文件地址
     */
    private String getFilePath(FileEnum category) {
        switch (category) {
            case FILE:
                return commonFileProperties.getFile();
            case VIDEO:
                return commonFileProperties.getVideo();
            case IMAGE:
                return commonFileProperties.getImage();
            default:
                throw new BusinessException("文件类型错误!");
        }
    }

    /**
     * 获得文件的原始名称
     *
     * @param file 文件
     * @return 去掉首位空格的文件名称
     */
    private String getOriginalFilename(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (null == originalFilename || "".equals(originalFilename)) {
            throw new BusinessException("文件的名称不能为空!");
        }
        return originalFilename.trim();
    }

    /**
     * 生成唯一名称
     *
     * @return 唯一名称
     */
    private String getUUIDName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 通过文件原来的名称和文件类型查询文件
     *
     * @param realName 文件原来的名称
     * @param category 文件类型
     * @return FileMapper Mapper实体
     */
    private FileMapper findByRealNameAndCategory(String realName, FileEnum category) {
        return fileMapperRepo.findByRealNameAndCategory(realName, category);
    }
}
