package producerconsumer;

import java.util.concurrent.*;

public class MessageExchanger {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingDeque<>();
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.submit(producer);
        executor.submit(consumer);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();
    }
}
