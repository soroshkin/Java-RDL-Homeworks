package io.humb1t.orders;

import java.util.Objects;

public class Order {
    public final OrderStatus status;
    private int numberOfItemsInOrder;

    public Order(OrderStatus status) {
        this.status = status;
    }

    public Order(OrderStatus status, int numberOfItemsInOrder) {
        this.status = status;
        this.numberOfItemsInOrder = numberOfItemsInOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getNumberOfItemsInOrder() {
        return numberOfItemsInOrder;
    }

    public boolean isEqualOrLessItems(int items){
        return this.numberOfItemsInOrder <= items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return numberOfItemsInOrder == order.numberOfItemsInOrder &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, numberOfItemsInOrder);
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", items=" + numberOfItemsInOrder +
                '}';
    }
}