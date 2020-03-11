package io.humb1t;

import io.humb1t.orders.Action;
import io.humb1t.orders.Order;
import io.humb1t.orders.OrderStatus;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class CollectionBenchmark {
    private final Random randomStatus = new Random();

    public enum MethodNames {
        DELETE("delete all elements"), SEARCH("search elements"), INSERT("insert elements");
        String name;

        public String getName() {
            return name;
        }

        MethodNames(String name) {
            this.name = name;
        }
    }

    public void getFilledList(Collection<Order> collection, int numberOfElementsInList) {
        OrderStatus[] orderStatuses = OrderStatus.values();

        for (int i = 0; i < numberOfElementsInList; i++) {
            collection.add(new Order(orderStatuses[randomStatus.nextInt(orderStatuses.length)], i));
        }
    }

    public <T> long deleteAllElements(Collection<T> collection) {
        return measureTime(() -> {
            for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); ) {
                iterator.next();
                iterator.remove();
            }
        });
    }

    public long insertElements(Collection<Order> collection, int numberOfElements) {
        return measureTime(() -> {
            for (int i = 0; i < numberOfElements; i++) {
                collection.add(new Order(OrderStatus.COMPLETED, i));
            }
        });
    }

    public long searchElement(Collection<Order> collection, int orderItems) {
        return measureTime(() -> {
            for (int i = 0; i < 1000; i++) {
                collection.contains(new Order(OrderStatus.COMPLETED, orderItems));
            }
        });
    }

    public long measureTime(Action action) {
        long beginTime = System.nanoTime();
        action.makeAction();
        return System.nanoTime() - beginTime;
    }

    public void printResults(long nanoTime, Collection<Order> collection, String methodName) {
        System.out.printf("%d %s %s%n", nanoTime, collection.getClass().getSimpleName(), methodName);
    }
}
