package philosophers;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private final Semaphore semaphore;
    private String name;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name, Semaphore semaphore) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

            thinks();
            getForks();
            if (leftFork.getLock().isHeldByCurrentThread() && rightFork.getLock().isHeldByCurrentThread()) {
                eats();
            }

            if (leftFork.getLock().isHeldByCurrentThread()) {
                leftFork.putBack();
                System.out.println(name + " puts " + leftFork.getName());
            }
            if (rightFork.getLock().isHeldByCurrentThread()) {
                rightFork.putBack();
                System.out.println(name + " puts " + rightFork.getName());
            }
            semaphore.release();

            //yield() for quicker switches between threads
            Thread.yield();
        }
    }

    public void getForks() {
        leftFork.take();
        System.out.println(name + " takes " + leftFork.getName());
        rightFork.take();
        System.out.println(name + " takes " + rightFork.getName());
    }

    public void thinks() {
        System.out.println(name + " thinks");

    }

    public void eats() {
        System.out.println(name + " eats");
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "name='" + name + '\'' +
                ", leftFork=" + leftFork.getName() +
                ", rightFork=" + rightFork.getName() +
                '}';
    }
}
