package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> c = Collections.EMPTY_LIST;
        List<String> list = new ArrayList<>(c);

        List<Order> orders = Collections.singletonList(new Order(OrderStatus.COMPLETED));
        orders.stream()
                .filter(order -> order.status == OrderStatus.COMPLETED)
                .forEach(order -> System.out.println(order.toString()));
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();){
            System.out.println(iterator.next().toString());
        }
        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }


    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final OrderStatus status;

        public Order(OrderStatus status) {
            this.status = status;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }
}
