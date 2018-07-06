package com.github.vendigo.learntest;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash("orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private Long id;
    private String author;
    private List<String> items;
}
