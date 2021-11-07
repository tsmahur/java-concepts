package com.synchronization;

public class SynchronizedBlock {
    public static void main(String args[]) {
        TableSyncBlock obj = new TableSyncBlock(); //common shared resource
//        TableSyncBlock obj2 = new TableSyncBlock();
        Thread threadUsingAnonymousThread1 = new Thread(() -> obj.printTableSync(5),"thread1");
        Thread threadUsingAnonymousThread2 = new Thread(() -> obj.printTableSync(6),"thread2");
//        Thread threadUsingAnonymousThread2= new Thread(() -> obj2.printTableSync(6));
        threadUsingAnonymousThread1.start();
        threadUsingAnonymousThread2.start();
    }
}

class TableSyncBlock {

    void printTableSync(int n){
        System.out.println("printing method begin :: this line is not synced (outside synchronized block) :"+Thread.currentThread().getName());

        synchronized (this) { //object reference or class name TableSyncBlock.class or resource
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
    }
}