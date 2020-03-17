package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        long messageNumber = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Message message = new Message("message #" + messageNumber++);
                System.out.println("put " + message);
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
