package com.github.vendigo.learntest;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;

public class OrderRedisSerializer extends GenericJackson2JsonRedisSerializer {

    public OrderRedisSerializer() {
        super(Jackson2ObjectMapperBuilder.json()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .build());
    }

    @Override
    public Object deserialize(final byte[] source) {
        return deserialize(source, OrderRedisSerializer.class);
    }
}
