package com.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        //pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 20; i++) {
            Runnable worker = new ThreadPoolRunnable(i);
            executor.execute(worker);
        }

        executor.shutdown(); // prog not ending

        System.out.println("Finished all threads");
    }
}

class ThreadPoolRunnable implements Runnable {
    private int myInt;

    public ThreadPoolRunnable(int myInt) {
        this.myInt = myInt;
    }

    @Override
    public void run() {
        System.out.println("Start::"+Thread.currentThread().getName() + " : i = " + this.myInt);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End::"+Thread.currentThread().getName());
    }
}
