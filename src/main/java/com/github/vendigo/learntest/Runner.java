package com.github.vendigo.learntest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private final PetService petService;
    private final GreetingService greetingService;

    @Override
    public void run(final String... args) {
        log.info("-------------- Start actions --------------");
        greetingService.sayHello();
        petService.feedTheDog("Bim");
        petService.petTheCat("Murka");
        petService.feedTheCat("Romka");
        greetingService.sayGoodbye();
        log.info("-------------- Finish actions --------------");
    }
}
