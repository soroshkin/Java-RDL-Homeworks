package io.humb1t.inheritance;

/**
 * Interface should be used to define ability to be executed by //TODO: create a Process.
 *
 * @author Nikita_Puzankov
 */
public interface Executable {
    public void start();
    public void stop();
    public void cancel();
}
