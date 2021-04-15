package com.unfrost.core.controller;

import com.unfrost.core.domain.FileMapper;
import com.unfrost.core.domain.FileMapperDomainService;
import com.unfrost.core.repo.FileMapperRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-15 08:43
 */
@Api(tags = "获取文件信息")
@RestController
@AllArgsConstructor
public class FileMapperController {
    private final FileMapperRepo fileMapperRepo;
    private final FileMapperDomainService fileMapperDomainService;

    @ApiOperation("查询文件信息")
    @GetMapping
    public FileMapper findById(@RequestParam String id) {
        return fileMapperRepo.findByIdThrow(id);
    }

    @ApiOperation("修改文件名称")
    public FileMapper update(@RequestParam String name,
                             @RequestParam String id){
        return fileMapperDomainService.update(id,name);
    }
}
