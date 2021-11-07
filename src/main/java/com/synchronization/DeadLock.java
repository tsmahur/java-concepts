package com.synchronization;

public class DeadLock {
    public static void main(String[] args) {
        String resource1="resource1Value";
        String resource2="resource2Value";

        //making deadlock
        Thread threadUsingAnonymousThread1= new Thread(() -> {
//            synchronized (resource1) {
//                System.out.println(Thread.currentThread().getName() + ", resource1 : " + resource1);
//
////                System.out.println(Thread.currentThread().getName() + ", waiting for resource2 ");
//                try { Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
//                synchronized (resource2) {
//                    System.out.println(Thread.currentThread().getName() + ", resource2 : " + resource2);
//                }
//            }
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() +": locked resource 1 : "+resource1);

                try { Thread.sleep(100);} catch (Exception e) {e.printStackTrace();}

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() +": locked resource 2 : "+resource2);
                }
            }

        },"thread1");
        Thread threadUsingAnonymousThread2= new Thread(() -> {
//            synchronized (resource1) {
//                System.out.println(Thread.currentThread().getName() + ", resource2 : " + resource2);
//
////                System.out.println(Thread.currentThread().getName() + ", waiting for resource1 ");
//                try { Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
//
//                synchronized (resource2) {
//                    System.out.println(Thread.currentThread().getName() + ", resource1 : " + resource1);
//                }
//            }
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() +": locked resource 2 : "+resource2);

                try { Thread.sleep(100);} catch (Exception e) {e.printStackTrace();}

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() +" locked resource 1 : "+resource1);
                }
            }

        },"thread2");
        threadUsingAnonymousThread1.start();
        threadUsingAnonymousThread2.start();
    }
}
