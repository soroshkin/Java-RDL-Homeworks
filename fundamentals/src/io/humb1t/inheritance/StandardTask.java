package io.humb1t.inheritance;

/**
 * Abstract default implementation of {@link Executable}.
 *
 * @author Nikita_Puzankov
 */
public abstract class StandardTask implements Executable, Observable {
    protected TaskStatus status;

    @Override
    public void stop() {
        if (TaskStatus.CANCELLED.equals(this.status) || TaskStatus.FAILED.equals(this.status)
                || TaskStatus.COMPLETED.equals(this.status)) {
            throw new IllegalStateException("Incorrect task status");
        }
        this.status = TaskStatus.STOPPED;
    }

    @Override
    public void cancel() {
        if (TaskStatus.CANCELLED.equals(this.status) || TaskStatus.FAILED.equals(this.status)
                || TaskStatus.COMPLETED.equals(this.status)) {
            throw new IllegalStateException("Incorrect task status");
        }
        this.status = TaskStatus.CANCELLED;
    }

    @Override
    public TaskStatus getStatus() {
        return this.status;
    }
}
