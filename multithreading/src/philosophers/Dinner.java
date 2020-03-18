package philosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Dinner {
    private static final int NUMBER_OF_PHILOSOPHERS = 5;
    private static final int NUMBER_OF_FORKS = NUMBER_OF_PHILOSOPHERS;

    public static void main(String[] args) {
        Fork[] forks = new Fork[NUMBER_OF_FORKS];
        for (int i = 0; i < NUMBER_OF_FORKS; i++) {
            forks[i] = new Fork("fork #" + i);
        }

        List<Thread> threads = new ArrayList<>(NUMBER_OF_PHILOSOPHERS);

        //number of permits should be less than number of philosophers to avoid deadlock
        Semaphore semaphore = new Semaphore(NUMBER_OF_PHILOSOPHERS - 1);
        for (int i = 0; i < NUMBER_OF_FORKS; i++) {
            Philosopher philosopher = new Philosopher("philosopher #" + i, semaphore);

            philosopher.setLeftFork(forks[i]);
            philosopher.setRightFork(forks[(i + 1) % NUMBER_OF_FORKS]);

            Thread thread = new Thread(philosopher);
            threads.add(thread);
            thread.start();
        }
    }
}
