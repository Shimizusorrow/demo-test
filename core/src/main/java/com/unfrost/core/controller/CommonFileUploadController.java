package com.unfrost.core.controller;

import com.unfrost.core.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 14:07
 */
@Api(tags = "文件上传")
@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class CommonFileUploadController {
    private final UploadFileService uploadFileService;

    @PostMapping("/images")
    @ApiOperation("上传图片")
    public String uploadImage(@RequestPart("file") MultipartFile file) {
        return uploadFileService.uploadImage(file);
    }

    @PostMapping("/vedioes")
    @ApiOperation("上传视屏")
    public String uploadVideo(@RequestPart("file") MultipartFile file) {
        return uploadFileService.uploadVideo(file);
    }

    @PostMapping("/files")
    @ApiOperation("上传普通文件")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
        return uploadFileService.uploadFile(file);
    }
}
