package philosophers;

public class Fork {
    private String name;
    private boolean isTaken;

    public String getName() {
        return name;
    }

    public Fork(String name) {
        this.name = name;
    }

    /**
     * Tries to take fork
     * @return true if  fork is taken
     */
    public boolean takeFork() {
        if (isTaken){
            return false;
        }
        return isTaken = true;
    }


    /**
     * Releases the lock of the fork
     */
    public void putBackFork() {
        isTaken = false;
        System.out.println(name + " has been put back");
    }
}
