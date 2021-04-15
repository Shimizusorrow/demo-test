package com.unfrost.core.domain;

import com.unfrost.core.event.UpLoadFileEvent;
import com.unfrost.core.repo.FileMapperRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 14:43
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class FileMapperDomainService {
    private final FileMapperRepo fileMapperRepo;

    /**
     * 生成映射关系
     *
     * @param event
     */
    @Async
    @EventListener
    public void when(UpLoadFileEvent event) {
        fileMapperRepo.save(event.getMapper());
    }

    public FileMapper update(String id, String name) {
        FileMapper fileMapper = fileMapperRepo.findByIdThrow(id);
        fileMapper.updateName(name);
        return fileMapperRepo.save(fileMapper);
    }
}
