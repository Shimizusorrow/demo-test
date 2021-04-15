package com.unfrost.common.util;

import com.unfrost.common.constant.PunctuationConstants;
import com.unfrost.common.exception.BusinessException;
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
            e.printStackTrace();
        }
    }
}
