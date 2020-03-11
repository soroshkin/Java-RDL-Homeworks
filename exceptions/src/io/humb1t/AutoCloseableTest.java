package io.humb1t;

public class AutoCloseableTest implements AutoCloseable{

    public void printMessage(String message){
        System.out.println(message);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource is closed");
    }
}
