package com.example.george.study.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication(scanBasePackages = {"com.example.george"},exclude=DataSourceAutoConfiguration.class)
@TestPropertySource(value = "classpath:service-test.properties")
//@EnableTransactionManagement
public class TestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

}
