package io.humb1t;

import io.humb1t.cache.URLCache;
import io.humb1t.orders.Action;
import io.humb1t.orders.Order;
import io.humb1t.orders.OrderStatus;
import io.humb1t.request.Request;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        //second task
        List<Order> ordersToFilter = new ArrayList<>();
        getFilledList(ordersToFilter, 140);

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
        printBenchmarkResults(insertElementsBenchmark(orderDeque, numberOfElementsToAdd), orderDeque, "insert elements");
        printBenchmarkResults(insertElementsBenchmark(orderSet, numberOfElementsToAdd), orderSet, "insert elements");

        printBenchmarkResults(searchElementBenchmark(orderDeque, orderDeque.size() / 2), orderDeque, "search elements");
        printBenchmarkResults(searchElementBenchmark(orderSet, orderSet.size() / 2), orderSet, "search elements");

        printBenchmarkResults(deleteAllElementsBenchmark(orderDeque), orderDeque, "delete all elements");
        printBenchmarkResults(deleteAllElementsBenchmark(orderSet), orderSet, "delete all elements");

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

    private static final Random RANDOM_STATUS = new Random();

    public static void getFilledList(Collection<Order> collection, int numberOfElementsInList) {
        OrderStatus[] orderStatuses = OrderStatus.values();

        for (int i = 0; i < numberOfElementsInList; i++) {
            collection.add(new Order(orderStatuses[RANDOM_STATUS.nextInt(orderStatuses.length)], i));
        }
    }

    public static <T> long deleteAllElementsBenchmark(Collection<T> collection) {
        return measureTime(() -> {
            for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); ) {
                iterator.next();
                iterator.remove();
            }
        });
    }

    public static long insertElementsBenchmark(Collection<Order> collection, int numberOfElements) {
        return measureTime(() -> {
            for (int i = 0; i < numberOfElements; i++) {
                collection.add(new Order(OrderStatus.COMPLETED, i));
            }
        });
    }

    public static long searchElementBenchmark(Collection<Order> collection, int orderItems) {
        return measureTime(() -> {
            for (int i = 0; i < 1000; i++) {
                collection.contains(new Order(OrderStatus.COMPLETED, orderItems));
            }
        });
    }

    public static long measureTime(Action action) {
        long beginTime = System.nanoTime();
        action.makeAction();
        return System.nanoTime() - beginTime;
    }

    public static void printBenchmarkResults(long nanoTime, Collection<Order> collection, String methodName) {
        System.out.printf("%d %s %s%n", nanoTime, collection.getClass().getSimpleName(), methodName);
    }
}
