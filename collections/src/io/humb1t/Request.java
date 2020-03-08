package io.humb1t;

public class Request implements Runnable {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "data='" + data + '\'' +
                '}';
    }

    @Override
    public void run() {
        System.out.println(toString() + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
