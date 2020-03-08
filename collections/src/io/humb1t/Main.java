package io.humb1t;

import java.util.*;
import java.util.concurrent.*;

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

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                threadPoolExecutor.execute(new Request(i + " request"));
            }
        }).start();

        try {
            threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        Map<String, URL> cache = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            URL url = new URL("http://" + i, new Object());
            cache.put(url.getName(), url);
        }

        URL urlFromCache = cache.get("http://5");
        if (urlFromCache != null) {
            System.out.println(urlFromCache);
        }

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
