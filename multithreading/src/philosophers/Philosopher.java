package philosophers;

public class Philosopher implements Runnable {
    private String name;
    private Fork leftFork;
    private Fork rightFork;

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public Philosopher(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (hasTakenForks()) {
                eats();
                leftFork.putBackFork();
                rightFork.putBackFork();
            } else {
                thinks();
            }
        }
    }

    public boolean hasTakenForks() {
        if (leftFork.takeFork()) {
            System.out.println(name + " takes left " + leftFork.getName());
            if (rightFork.takeFork()) {
                System.out.println(name + " takes right " + rightFork.getName());
                return true;
            } else {
                System.out.println(name + " couldn't take right fork");
                leftFork.putBackFork();
            }

        }
        System.out.println(name + " couldn't take forks");
        return false;
    }

    public void thinks() {
        //чтобы  в консоли удобнее было находить метод
        System.out.println(name + " ====================== thinks ==================================");
    }

    public void eats() {
        //чтобы  в консоли удобнее было находить метод
        System.out.println(name + " eats !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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
