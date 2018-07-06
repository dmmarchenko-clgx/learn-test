package com.github.vendigo.learntest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private final OrdersRepository ordersRepository;

    @Override
    public void run(final String... args) {
        final Order order1 = new Order(1L, "Dmytro", Arrays.asList("Xiaomi Mi router 3", "Drobak USB Type-C wire"));
        final Order order2 = new Order(2L, "Ivan", Arrays.asList("Samsung Gear 3 Sport", "Samsung Galaxy Note 8"));
        ordersRepository.save(Arrays.asList(order1, order2));
        printOrders();

        final Order order3 = new Order(3L, "Petro", Arrays.asList("Samsung Gear 4", "Samsung Galaxy Note 9"));
        ordersRepository.save(order3);
        printOrders();

        ordersRepository.deleteAll();
        printOrders();
    }

    private void printOrders() {
        log.info("Orders:");
        ordersRepository.findAll().forEach(order -> log.info("{}", order));
    }
}
