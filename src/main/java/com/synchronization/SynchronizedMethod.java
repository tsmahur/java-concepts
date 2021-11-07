package com.synchronization;

public class SynchronizedMethod {
    public static void main(String args[]) {
        TableSync obj = new TableSync(); //common shared resource
//        TableSync obj2 = new TableSync();
        Thread threadUsingAnonymousThread1= new Thread(() -> obj.printTableSync(5));
        Thread threadUsingAnonymousThread2= new Thread(() -> obj.printTableSync(6));
//        Thread threadUsingAnonymousThread2= new Thread(() -> obj2.printTableSync(6));
        threadUsingAnonymousThread1.start();
        threadUsingAnonymousThread2.start();
    }
}

class TableSync{
    //method synchronized
    synchronized void printTableSync(int n) {
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