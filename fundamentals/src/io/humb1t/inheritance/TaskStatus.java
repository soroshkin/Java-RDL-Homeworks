package io.humb1t.inheritance;

/**
 * Status enumeration for {@link Executable}.
 *
 * @author Nikita_Puzankov
 */
public enum TaskStatus {
    NOT_STARTED(0), PROCESSING(1), STOPPED(2), COMPLETED(3), CANCELLED(4), FAILED(5);

    public final int code;

    TaskStatus(int code) {
        this.code = code;
    }
}
