package philosophers;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private String name;
    //Lock could be replaced with synchronized methods or blocks, but I chose it to practice
    private final ReentrantLock lock = new ReentrantLock();

    public ReentrantLock getLock() {
        return lock;
    }

    public String getName() {
        return name;
    }

    public Fork(String name) {
        this.name = name;
    }

    /**
     * Tries to take fork and locks it
     */
    public void take() {
        lock.lock();
    }

    /**
     * Releases the lock of the fork
     */
    public void putBack() {
        lock.unlock();
    }
}
