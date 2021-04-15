package com.unfrost.common.properties;

import cn.hutool.core.util.StrUtil;
import com.unfrost.common.exception.BusinessException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 13:58
 */
@Component
@ConfigurationProperties(prefix = CommonFileProperties.PREFIX)
public class CommonFileProperties {
    public static final String PREFIX = "common-file";
    private static final String SLASH = "/";
    private final String DEFAULT_IMAGE_PATH = "./data/image/";
    private final String DEFAULT_VIDEO_PATH = "./data/video/";
    private final String DEFAULT_FILE_PATH = "./data/file/";
    /**
     * 默认图片地址
     */
    private String image = DEFAULT_IMAGE_PATH;

    /**
     * 默认视屏地址
     */
    private String video = DEFAULT_VIDEO_PATH;

    /**
     * 默认文件地址
     */
    private String file = DEFAULT_FILE_PATH;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        judgePath(image, "图片文件路径不可为空");
        this.image = setFilePathSlash(image);
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        judgePath(video, "视屏文件路径不可为空");
        this.video = setFilePathSlash(video);
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        judgePath(file, "普通文件路径不可为空");
        this.file = setFilePathSlash(file);
    }

    /**
     * 设置文件末尾为/
     *
     * @param path
     * @return
     */
    private String setFilePathSlash(String path) {
        if (!path.endsWith(SLASH)) {
            path = path + SLASH;
        }
        return path;
    }

    /**
     * 判断文件是否为空
     *
     * @param path
     * @param msg
     */
    private void judgePath(String path, String msg) {
        if (StrUtil.isEmpty(path)) {
            throw new BusinessException(msg);
        }
    }

    /**
     * 生成文件夹
     *
     * @param address 地址信息
     * @param msg     类型
     */
    private void mkdir(String address, String msg) {
        File file = Paths.get(address).toFile();
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new RuntimeException(String.format("%s的文件夹存储地址必须是一个文件夹", msg));
            }
        } else {
            boolean created = file.mkdirs();
            if (!created) {
                throw new RuntimeException(String.format("创建%s文件夹失败", msg));
            }
        }
    }

    /**
     * 生成文件夹
     */
    public void mkdirs() {
        mkdir(getFile(), "普通文件");
        mkdir(getImage(), "图片文件");
        mkdir(getVideo(), "视屏文件");
    }
}
