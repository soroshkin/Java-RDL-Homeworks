package philosophers;

import java.util.ArrayList;
import java.util.List;

public class Dinner {
    private static final int NUMBER_OF_PHILOSOPHERS = 5;
    private static final int NUMBER_OF_FORKS = NUMBER_OF_PHILOSOPHERS;

    public static void main(String[] args) {
        List<Philosopher> philosopherList = new ArrayList<>(5);
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            philosopherList.add(new Philosopher("philosopher-" + i));
        }

        for (int i = 0; i < NUMBER_OF_FORKS; i++) {
            Fork fork = new Fork();
            if (i != NUMBER_OF_FORKS - 1) {
                philosopherList.get(i).setRightFork(fork);
                philosopherList.get(i + 1).setLeftFork(fork);
            } else {
                philosopherList.get(0).setLeftFork(fork);
                philosopherList.get(i).setRightFork(fork);
            }
        }

        for (Philosopher p:philosopherList
             ) {
            new Thread(p).start();
        }
    }
}
