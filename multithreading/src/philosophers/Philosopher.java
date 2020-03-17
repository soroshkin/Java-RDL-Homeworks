package philosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private static final Lock lock = new ReentrantLock();
    Condition leftForkCondition = lock.newCondition();
    Condition rightForkCondition = lock.newCondition();

    @Override
    public String toString() {
        return "Philosopher{" +
                "name='" + name + '\'' +
                ", leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                '}';
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public Philosopher(String name) {
        this.name = name;
    }

    public boolean acquireLeftFork() {
        return true;
    }

    public boolean acquireRightFork() {
        return true;
    }

    public void thinks() {
        System.out.println(name + " thinks");
    }

    public void eats() {
        System.out.println(name + " eats");
    }


    @Override
    public void run() {

    }
}
