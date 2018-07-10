package com.github.vendigo.learntest;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import lombok.AllArgsConstructor;
import redis.embedded.RedisServer;

@Configuration
@AllArgsConstructor
public class RedisConfig {

    private final RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTemplate<String, Order> stringSortedBillingMerchantsRedisTemplate(final RedisSerializer serializer) {
        final RedisTemplate<String, Order> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public static RedisSerializer serializer() {
        return new OrderRedisSerializer();
    }

    @Profile("embeddedRedis")
    @Bean(destroyMethod = "stop")
    public RedisServer localRedisServer() throws IOException {
        final RedisServer redisServer = new RedisServer(6379);
        redisServer.start();
        return redisServer;
    }

}
