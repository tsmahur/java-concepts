package com.multiThreading;

public class ThreadState{

    public static Thread thread1;
    public static Runnable1 obj;

    public static void main(String[] args) {
        obj = new Runnable1();
        thread1 = new Thread(obj);// thread 1 - NEW state
        System.out.println("The state of thread1 - " + thread1.getState());

        thread1.start(); // thread 1 is moved to the Runnable state
        System.out.println("The state of thread1 after invoking start() - " + thread1.getState());

        System.out.println("end of Class ThreadState.main()");
    }

}


class Runnable2 implements Runnable {

    @Override
    public void run() {
        System.out.println("--- inside Class Runnable2.run() ---");
        try {

            Thread.sleep(100);// moving thread t2 to the state timed waiting

            System.out.println("Sleep:100 done; The state of thread1 while it invoked join() on thread2 -" + ThreadState.thread1.getState());

            Thread.sleep(200);
            System.out.println("Sleep:200 done Runnable2.run()");

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("--- end of Class Runnable2.run() ---");
    }
}

class Runnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println("--- inside Class Runnable1.run() ---");
        Runnable2 myObj = new Runnable2();
        Thread thread2 = new Thread(myObj);// thread2 - NEW state

        try {
            System.out.println("The state of thread2- " + thread2.getState());
            thread2.start();// thread2 is moved to the runnable state
            System.out.println("the state of thread2 after calling start() - " + thread2.getState());

            Thread.sleep(200);// moving thread1 to the state timed waiting (after this control goes to runnable2)
            System.out.println("Sleep:200 ;The state of thread2 after invoking  sleep() Runnable1.run()- " + thread2.getState());

            // waiting for thread2 to complete its execution
            System.out.println("-- thread2.join() executing...");
            thread2.join();
            System.out.println("-- thread2.join() executed --");

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("The state of thread2 when it has completed execution - " + thread2.getState());
        System.out.println("----end of Class Runnable1.run()---");
    }
}
