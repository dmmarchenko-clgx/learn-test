package com.github.vendigo.learntest;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {

    public void sayHello() {
        log.info("Hello, my name is Dima");
    }

    @Switchable
    public void sayGoodbye() {
        log.info("Bye!");
    }
}
