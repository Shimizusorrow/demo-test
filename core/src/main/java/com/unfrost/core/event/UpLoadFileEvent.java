package com.unfrost.core.event;

import com.unfrost.core.domain.FileMapper;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 上传文件事件
 *
 * @author Shimizu
 * @description
 * @date 2021-04-14 15:00
 */
@Getter
public class UpLoadFileEvent extends ApplicationEvent {
    private FileMapper mapper;

    public UpLoadFileEvent(FileMapper mapper) {
        super(mapper);
        this.mapper = mapper;
    }
}
