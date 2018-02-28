package com.github.vendigo.learntest;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogComponent {

    @PostConstruct
    public void init() {
        log.info("ApplicationContext refresh");
    }
}
