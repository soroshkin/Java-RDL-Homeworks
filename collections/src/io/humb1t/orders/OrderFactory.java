package io.humb1t.orders;

public interface OrderFactory {

    default Order createNotStartedOrder() {
        return new Order(OrderStatus.NOT_STARTED);
    }

    default Order createProcessingOrder() {
        return new Order(OrderStatus.PROCESSING);
    }

    default Order createCompletedOrder() {
        return new Order(OrderStatus.COMPLETED);
    }
}
