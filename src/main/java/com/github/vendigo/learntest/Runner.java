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

    private final OrdersService ordersService;

    @Override
    public void run(final String... args) {
        final Order order1 = new Order("Dmytro", Arrays.asList("Xiaomi Mi router 3", "Drobak USB Type-C wire"));
        final Order order2 = new Order("Ivan", Arrays.asList("Samsung Gear 3 Sport", "Samsung Galaxy Note 8"));
        final Order order3 = new Order("Petro", Arrays.asList("Samsung Gear 4", "Samsung Galaxy Note 9"));
        ordersService.put(1L, order1);
        ordersService.put(2L, order2);
        ordersService.put(3L, order3);

        //ordersService.deleteAll();
    }
}
