package com.dev.latest;

class VolatileUpdated {

    private volatile boolean running = true;

    public void addition() {

        while (running) {
            int a = 10;
            int b = 20;
            int c = a + b;

            System.out.println(
                "Thread Name: " +
                Thread.currentThread().getName() +
                " : " + c
            );
        }

        System.out.println(
            Thread.currentThread().getName() + " stopped"
        );
    }

    public void stop() {
        running = false;
    }
}

public class VolatileMainUpdated {

    public static void main(String[] args) throws InterruptedException {

        VolatileUpdated volatileUpdated = new VolatileUpdated();

        Thread t1 = new Thread(volatileUpdated::addition, "Thread-1");
        Thread t2 = new Thread(volatileUpdated::addition, "Thread-2");

        t1.start();
        t2.start();

        Thread.sleep(100);

        volatileUpdated.stop();
    }
}
