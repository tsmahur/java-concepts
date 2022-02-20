package com.multiThreading.synchronization;

public class WithoutSync {
    public static void main(String args[]) {
        Table obj = new Table();// //common shared resource
//        Table obj2 = new Table();
        Thread threadUsingAnonymousThread1 = new Thread(() -> obj.printTable(5), "thread1");
        Thread threadUsingAnonymousThread2 = new Thread(() -> obj.printTable(6), "thread2");
//        Thread threadUsingAnonymousThread2 = new Thread(() -> obj2.printTable(6),"thread2");
        threadUsingAnonymousThread1.start();
        threadUsingAnonymousThread2.start();
    }
}

class Table {
    //method not synchronized
    void printTable(int n) {
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