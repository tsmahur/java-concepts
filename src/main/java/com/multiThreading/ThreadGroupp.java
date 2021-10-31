package com.multiThreading;

public class ThreadGroupp {
    public static void main(String[] args) {
        MyRunnable myRunnable =new MyRunnable();
        ThreadGroup threadGroup1 = new ThreadGroup("threadGroup1");
//        MyThread thread0 = new MyThread(threadGroup1,myRunnable,"thread0");
        Thread thread0 = new Thread(threadGroup1,myRunnable,"thread0");
        Thread thread1 = new Thread(threadGroup1,myRunnable,"thread1");
        Thread thread2 = new Thread(threadGroup1,myRunnable,"thread2");

        thread0.start();
        thread1.start();
        thread2.start();

        threadGroup1.list();
        System.out.println("active thread : "+threadGroup1.activeCount());

    }
}
