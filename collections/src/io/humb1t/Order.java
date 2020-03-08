package io.humb1t;

import java.util.Objects;

public class Order {
    public final OrderStatus status;
    private int items;


    public Order(OrderStatus status) {
        this.status = status;
    }

    public Order(OrderStatus status, int items) {
        this.status = status;
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return items == order.items &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, items);
    }
}