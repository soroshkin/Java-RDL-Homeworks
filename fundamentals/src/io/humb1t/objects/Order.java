package io.humb1t.objects;

import java.util.Objects;

/**
 * Example of Order java class with all possible elements.
 *
 * @author Nikita_Puzankov
 */
public class Order {
    private final static java.util.Random ID_SEQUENCE;

    static {
        System.out.println("Static Code Block");
        ID_SEQUENCE = new java.util.Random(999l);
    }

    private final Long id;
    private final String title;
    private OrderStatus status;

    {
        System.out.println("Code Block");
        this.id = ID_SEQUENCE.nextLong();
    }


    public Order(String title) {
        System.out.println("Constructor");
        this.title = title;
        this.status = OrderStatus.NOT_STARTED;
    }

    public void start() {
        if (!OrderStatus.NOT_STARTED.equals(this.status)) {
            throw new IllegalStateException("Order should be in NOT_STARTED state.");
        }
        this.status = OrderStatus.PROCESSING;
    }

    public boolean isReady() {
        return OrderStatus.COMPLETED.equals(this.status);
    }

    public boolean isFailed() {
        return OrderStatus.ERROR.equals(this.status);
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED, ERROR
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                title.equals(order.title) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
