package io.humb1t.inheritance;

import io.humb1t.objects.Order;

/**
 * Task is responsible for Order processing.
 *
 * @author Nikita_Puzankov
 */
public final class StartOrderTask extends StandardTask {

    private final Order order;

    public StartOrderTask(Order order) {
        this.order = order;
    }

    @Override
    public void start() {
        order.start();
        try {
            while (!order.isReady() && !order.isFailed()) {
                wait(1000l);
            }
        } catch (InterruptedException e) {
            this.status = TaskStatus.FAILED;
        }
        if (order.isReady()) {
            this.status = TaskStatus.COMPLETED;
        }
        if (order.isFailed()) {
            this.status = TaskStatus.FAILED;
        }
    }
}
