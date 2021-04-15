package com.unfrost.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.unfrost.common",
        "com.unfrost.admin",
        "com.unfrost.workspace",
        "com.unfrost.core"
})
public class WorkspaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkspaceApplication.class, args);
    }

}
