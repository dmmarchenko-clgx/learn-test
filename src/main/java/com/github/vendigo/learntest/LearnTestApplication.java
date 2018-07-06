package com.github.vendigo.learntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class LearnTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnTestApplication.class, args);
    }
}
