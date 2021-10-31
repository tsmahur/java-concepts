package com.multiThreading;

public class ThreadPriority {
    public static void main(String[] args) {
//        MyThread thread0 = new MyThread();
//        MyThread thread1 = new MyThread();
//        MyThread thread2 = new MyThread();

//        MyPrintThread thread0 = new MyPrintThread();
//        MyPrintThread thread1 = new MyPrintThread();
//        MyPrintThread thread2 = new MyPrintThread();

        MyPrintThreadNoSleep thread0 = new MyPrintThreadNoSleep();
        MyPrintThreadNoSleep thread1 = new MyPrintThreadNoSleep();
        MyPrintThreadNoSleep thread2 = new MyPrintThreadNoSleep();

        thread0.setName("thread0");
        thread1.setName("thread1");
        thread2.setName("thread2");

//        default :5, max :10 , min :1
        thread0.setPriority(1);
        thread1.setPriority(3);
        thread2.setPriority(10);

        thread0.start();
        thread1.start();
        thread2.start();
    }
}

class MyPrintThreadNoSleep extends Thread{
    @Override
    public void run() {
        System.out.println("thread MyPrintThreadNoSleep is running.... getState : " + this.getState() + "; name : " + this.getName()
                +" priority : "+this.getPriority());//Thread.currentThread().getName()
//        for (int i = 1; i < 4; i++) {
//            System.out.println("name : " + this.getName()+" i : "+i);
//        }
    }
}
