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
        //second task
        List<Order> ordersToFilter = new ArrayList<>();
        CollectionBenchmark benchmark = new CollectionBenchmark();
        benchmark.getFilledList(ordersToFilter, 140);

        ordersToFilter
                .stream()
                .filter(order -> order.getItems() > 30)
                .forEach(System.out::println);

        //third task
        BlockingQueue<Runnable> ordersQueue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, ordersQueue);
        threadPoolExecutor.prestartAllCoreThreads();

        for (int i = 0; i < 30; i++) {
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
        benchmark.printBenchmarkResults(benchmark.insertElementsBenchmark(orderDeque, numberOfElementsToAdd), orderDeque, INSERT.getName());
        benchmark.printBenchmarkResults(benchmark.insertElementsBenchmark(orderSet, numberOfElementsToAdd), orderSet, INSERT.getName());

        benchmark.printBenchmarkResults(benchmark.searchElementBenchmark(orderDeque, orderDeque.size() / 2), orderDeque, SEARCH.getName());
        benchmark.printBenchmarkResults(benchmark.searchElementBenchmark(orderSet, orderSet.size() / 2), orderSet, SEARCH.getName());

        benchmark.printBenchmarkResults(benchmark.deleteAllElementsBenchmark(orderDeque), orderDeque, DELETE.getName());
        benchmark.printBenchmarkResults(benchmark.deleteAllElementsBenchmark(orderSet), orderSet, DELETE.getName());

        //sixth task
        URLCache.fillCacheWithTestData();
        System.out.println(URLCache.getCacheSize());

        String urlToSearch = "webpage-1";
        URLCache.testCache(urlToSearch);

        urlToSearch = "hello";
        URLCache.testCache(urlToSearch);

        urlToSearch = "null page";
        URLCache.testCache(urlToSearch);
    }
}
