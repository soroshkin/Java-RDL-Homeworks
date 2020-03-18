package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Message message = new Message("message #" + queue.size());
                System.out.println("put " + message);
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void addOneMessage(Message message){
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
