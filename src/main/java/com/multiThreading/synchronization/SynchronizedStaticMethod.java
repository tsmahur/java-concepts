package com.multiThreading.synchronization;

public class SynchronizedStaticMethod {
    public static void main(String args[]) {
        Thread threadUsingAnonymousThread1 = new Thread(() -> TableSyncStaticMethod.tableSyncStaticMethod(5), "thread1");
        Thread threadUsingAnonymousThread2 = new Thread(() -> TableSyncStaticMethod.tableSyncStaticMethod(6), "thread2");
        threadUsingAnonymousThread1.start();
        threadUsingAnonymousThread2.start();
    }
}

class TableSyncStaticMethod {

    /*static void tableSyncStaticMethod(int n) {
            System.out.println("printing method begin :: this line is not synced (outside synchronized block) :"+Thread.currentThread().getName());

            synchronized (TableSyncStaticMethod.class) { //object reference or class name TableSyncStaticMethod.class /resource
                System.out.println("printing start :: this line is synced (inside synchronized block):"+Thread.currentThread().getName());

                for (int i = 1; i <= 10; i++) {
                    System.out.println(n * i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("printing ended :: this line is synced (inside synchronized block):"+Thread.currentThread().getName());
            }

            System.out.println("sleeping start :: this line is not synced (outside synchronized block):"+Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleeping end,print method ended :: this line is not synced (outside synchronized block):"+Thread.currentThread().getName());
    }*/
    synchronized static void tableSyncStaticMethod(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}