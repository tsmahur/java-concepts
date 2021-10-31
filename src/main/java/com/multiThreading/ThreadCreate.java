package com.multiThreading;

public class ThreadCreate extends Thread {
    public static void main(String[] args) throws InterruptedException {

        //Two ways to create thread
        //1.a. implementing Runnable interface
        MyRunnable myRunnable =new MyRunnable();
        Thread threadUsingRunnable= new Thread(myRunnable);
        threadUsingRunnable.start();
        System.out.println("thread using Runnable interface is started name: "+threadUsingRunnable.getName());

        //1.b. implementing Runnable interface - AnonymousRunnable
        Runnable anonymousRunnable = () -> System.out.println("thread using AnonymousRunnable is running.... name : "+Thread.currentThread().getName());
//        Runnable anonymousRunnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread using AnonymousRunnable is running.... name : "+Thread.currentThread().getName());
//            }
//        };
        Thread threadUsingAnonymousRunnable= new Thread(anonymousRunnable);
        threadUsingAnonymousRunnable.start();
        System.out.println("thread using threadUsingAnonymousRunnable is started name: "+threadUsingAnonymousRunnable.getName());

        //2.a. extending Thread class
        MyThread thread=new MyThread();
        System.out.println("Thread created -" + thread.getState());
        thread.start();
        System.out.println("after line thread.start() -" + thread.getState());

        //2.b. Thread Class const. Thread(String Name)
        Thread threadUsingNameConstructor= new Thread("threadUsingNameConstructor");
        threadUsingNameConstructor.start();
        System.out.println("thread using Thread(String Name) is started name: "+threadUsingNameConstructor.getName());

        //2.c. Thread Class const. Thread(Runnable r,String Name)
        MyRunnable myRunnable2 =new MyRunnable();
        Thread threadUsingRunnableAndNameConstructor= new Thread(myRunnable2,"threadUsingRunnableAndNameConstructor");
        threadUsingRunnableAndNameConstructor.start();
        System.out.println("thread using Thread(Runnable r,String Name) is started name: "+threadUsingRunnableAndNameConstructor.getName());

        //2.d. Thread Class - Anonymous
        Thread threadUsingAnonymousThread= new Thread(() -> System.out.println("thread using AnonymousThread is running.... name : "+Thread.currentThread().getName()));
//        Thread threadUsingAnonymousThread= new Thread(){
//            @Override
//            public void run() {
//                System.out.println("thread using MyRunnable is running.... name : "+Thread.currentThread().getName());
//            }
//        };
        threadUsingAnonymousThread.start();
        System.out.println("thread using Thread(()->{}) AnonymousThread is started name: "+threadUsingAnonymousThread.getName());

    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread MyThread is running.... getState : "+this.getState()+"; name : "+this.getName()+" priority : "+this.getPriority());
    }
}

 class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread using MyRunnable is running.... name : "+Thread.currentThread().getName());
    }
}


