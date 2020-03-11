package io.humb1t;

import io.humb1t.cache.URLCache;
import io.humb1t.orders.Order;
import io.humb1t.request.Request;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static io.humb1t.CollectionBenchmark.MethodNames.*;


public class Main {
    public static void main(String[] args) {
        //Part 2. Task 2
        List<Order> ordersToFilter = new ArrayList<>();
        CollectionBenchmark benchmark = new CollectionBenchmark();
        benchmark.getFilledList(ordersToFilter, 30);

        ordersToFilter
                .stream()
                .filter(order -> order.isEqualOrLessItems(5))
                .forEach(System.out::println);

        //third task
        BlockingQueue<Runnable> ordersQueue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, ordersQueue);
        threadPoolExecutor.prestartAllCoreThreads();

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Request(i + " request"));
        }

        threadPoolExecutor.shutdown();

        //fourth task
        Set<Order> uniqueOrders = new HashSet<>(ordersToFilter);
        System.out.println(uniqueOrders);

        //fifth task ArrayDeque vs HashSet
        Deque<Order> orderDeque = new ArrayDeque<>();
        Set<Order> orderSet = new HashSet<>();

        int numberOfElementsToAdd = 1_000_000;
        benchmark.printResults(benchmark.insertElements(orderDeque, numberOfElementsToAdd), orderDeque, INSERT.getName());
        benchmark.printResults(benchmark.insertElements(orderSet, numberOfElementsToAdd), orderSet, INSERT.getName());

        benchmark.printResults(benchmark.searchElement(orderDeque, orderDeque.size() / 2), orderDeque, SEARCH.getName());
        benchmark.printResults(benchmark.searchElement(orderSet, orderSet.size() / 2), orderSet, SEARCH.getName());

        benchmark.printResults(benchmark.deleteAllElements(orderDeque), orderDeque, DELETE.getName());
        benchmark.printResults(benchmark.deleteAllElements(orderSet), orderSet, DELETE.getName());

        //sixth task
        URLCache cache = new URLCache(100);
        cache.fillCacheWithTestData();
        cache.printCacheSize();

        String urlToSearch = "webpage-1";
        cache.testCache(urlToSearch);

        urlToSearch = "hello";
        cache.testCache(urlToSearch);

        urlToSearch = "null page";
        cache.testCache(urlToSearch);
    }
}
