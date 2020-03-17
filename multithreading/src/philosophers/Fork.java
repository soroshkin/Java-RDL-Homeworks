package philosophers;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private String name;
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
     * Tries to take fork
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
