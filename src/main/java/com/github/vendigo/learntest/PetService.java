package com.github.vendigo.learntest;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Switchable
public class PetService {

    public void feedTheDog(String dogName) {
        log.info("Feeding the dog: {}", dogName);
    }

    public void petTheCat(String catName) {
        log.info("Petting the cat: {}", catName);
    }

    void feedTheCat(String catName) {
        log.info("Feeding the cat: {}", catName);
    }
}
