package com.alex.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wsh
 * @date 2020-09-01
 */
@SpringBootApplication
public class SecKillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecKillApplication.class, args);
        System.out.println("http://localhost:10001");
    }
}
