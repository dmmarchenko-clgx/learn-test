package com.github.vendigo.learntest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @Autowired
    private Map<String, MyService> services;

    @Override
    public void run(final String... args) {
        log.info("Services: {}", services);
    }
}
