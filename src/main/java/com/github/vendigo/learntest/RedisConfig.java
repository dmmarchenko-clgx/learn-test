package com.github.vendigo.learntest;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.embedded.RedisServer;

@Configuration
public class RedisConfig {

    @Bean(destroyMethod = "stop")
    public RedisServer localRedisServer() throws IOException {
        final RedisServer redisServer = new RedisServer(6379);
        redisServer.start();
        return redisServer;
    }
}
