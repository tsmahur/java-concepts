package com.multiThreading;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        MyPrintThread thread1=new MyPrintThread();
        MyPrintThread thread2=new MyPrintThread();
        thread1.start();
//        Thread.sleep(3000); //sleep main method thread but do not affect the thread1
        thread2.start();
        thread2.start();//IllegalThreadStateException but do not stop execution of previous line thread2.start()
        // but code after this line in main method will not execute as this exception in occurred in main thread

        //sleep in main method thread
//        for (int j = 0; j < 5; j++) {
//            System.out.println(" j : "+j);
//            Thread.sleep(1000);
//        }

    }
}

//do not change below code as this class is used in multiple other classes
class MyPrintThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread MyPrintThread is running.... getState : " + this.getState() + "; name : " + this.getName()
                +" priority : "+this.getPriority());//Thread.currentThread().getName()
        for (int i = 1; i < 6; i++) {
            System.out.println("name : " + this.getName()+" i : "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}