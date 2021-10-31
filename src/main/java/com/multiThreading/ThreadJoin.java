package com.multiThreading;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        MyPrintThread thread1 = new MyPrintThread();
        MyPrintThread thread2 = new MyPrintThread();
        MyPrintThread thread3 = new MyPrintThread();

        thread1.start();

        thread1.join(); //when thread1 completes then thread2 and thread3 starts executing
//        thread1.join(50000);//when thread1 completes task or complete the specified time then thread2 and thread3 starts executing

        //join() waits for a thread to die so once thread1 dies/(time over of join) then execution will come below
        System.out.println("thread1.join() time over, thread1 state :" +thread1.getState());

        thread2.start();
        thread3.start();
    }
}
