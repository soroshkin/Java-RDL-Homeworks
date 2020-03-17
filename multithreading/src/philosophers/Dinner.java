package philosophers;

import java.util.ArrayList;
import java.util.List;

public class Dinner {
    private static final int NUMBER_OF_PHILOSOPHERS = 5;
    private static final int NUMBER_OF_FORKS = NUMBER_OF_PHILOSOPHERS;

    public static void main(String[] args) {
        Fork[] forks = new Fork[NUMBER_OF_FORKS];
        for (int i = 0; i < NUMBER_OF_FORKS; i++) {
            forks[i] = new Fork("fork #" + i);
        }

        List<Thread> threads = new ArrayList<>(NUMBER_OF_PHILOSOPHERS);
        for (int i = 0; i < NUMBER_OF_FORKS; i++) {
            Philosopher philosopher = new Philosopher("philosopher #" + i);

            philosopher.setLeftFork(forks[i]);
            philosopher.setRightFork(forks[(i+1) % NUMBER_OF_FORKS]);

            Thread thread = new Thread(philosopher);
            threads.add(thread);
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (Thread t : threads) {
//            t.interrupt();
//        }

    }
}
