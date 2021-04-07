package com.unfrost.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shimizu
 */
@SpringBootApplication(scanBasePackages = {
        "com.unfrost.common",
        "com.unfrost.admin"
})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
