package com.multiThreading;

public class ThreadRunDirectly {
    public static void main(String[] args) {
        MyPrintThread thread1 =new MyPrintThread();
        MyPrintThread thread2 =new MyPrintThread();

//        thread1.start();
//        thread2.start();

        //no context-switching, treated as normal object not thread object, executed on same stack
        thread1.run();
        thread2.run();
    }
}
