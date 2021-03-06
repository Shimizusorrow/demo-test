package com.unfrost.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shimizu
 */
@SpringBootApplication(scanBasePackages = {
        "com.unfrost.common",
        "com.unfrost.starter",
        "com.unfrost.admin",
        "com.unfrost.workspace",
        "com.unfrost.core"
})
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

}
