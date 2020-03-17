package io.humb1t;

import io.humb1t.orders.Order;

import java.util.*;

public class MainFunctional {
    public static void main(String[] args) {

        List<Order> ordersToFilter = new ArrayList<>();
        CollectionBenchmark benchmark = new CollectionBenchmark();
        benchmark.getFilledList(ordersToFilter, 30);

        ordersToFilter
                .stream()
                .filter(order -> order.isEqualOrLessItems(5))
                .forEach(System.out::println);
    }
}
