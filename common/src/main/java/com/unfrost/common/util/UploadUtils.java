package com.unfrost.common.util;

import com.unfrost.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 15:32
 */
@Async
public class UploadUtils {
    private static final Logger log = LoggerFactory.getLogger(UploadUtils.class);

    /**
     * 上传文件
     *
     * @param file
     * @param destPath
     * @param filename
     */
    public static void upLoadFile(MultipartFile file, String destPath, String filename) {
        File dest = new File(destPath, filename);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            log.error("文件上传失败");
            throw new BusinessException("文件上传失败:" + e.getMessage());
        }
    }
}
