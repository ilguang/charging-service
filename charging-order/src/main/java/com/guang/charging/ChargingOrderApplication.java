package com.guang.charging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guang
 * @date 2025/2/17 - 16:03
 */
@EnableFeignClients
@SpringBootApplication
public class ChargingOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChargingOrderApplication.class, args);
    }
}
