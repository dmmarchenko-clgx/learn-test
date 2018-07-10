package com.github.vendigo.learntest;

import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class OrdersService {

    private static final String ORDERS_KEY_PREFIX = "orders:";
    private static final String ORDERS_KEY_PATTERN = "orders:*";
    private RedisTemplate<String, Order> redisTemplate;

    public void put(long id, Order order) {
        redisTemplate.opsForValue().set(key(id), order);
    }

    public boolean exists(long id) {
        return redisTemplate.hasKey(key(id));
    }

    public Order get(long id) {
        return redisTemplate.opsForValue().get(key(id));
    }

    public void deleteAll() {
        final Set<String> keys = redisTemplate.keys(ORDERS_KEY_PATTERN);
        log.info("Deleting keys: {}", keys);
        redisTemplate.delete(keys);
    }

    private String key(final long id) {
        return ORDERS_KEY_PREFIX + id;
    }
}
