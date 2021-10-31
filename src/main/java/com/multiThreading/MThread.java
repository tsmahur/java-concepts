package com.multiThreading;

public class MThread extends Thread {
    public static void main(String[] args) throws InterruptedException {

        //1. extending Thread class
        MyThread thread=new MyThread();
        System.out.println("Thread created -" + thread.getState());

        thread.start();
        System.out.println("after line thread.start() -" + thread.getState());

//        sleep(2000);
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println("after line TimeUnit.SECONDS.sleep(1) -" + thread.getState());


        //2. implementing Runnable interface
        MyRunnable myRunnable =new MyRunnable();
        Thread threadUsingRunnable= new Thread(myRunnable);
        threadUsingRunnable.start();
        System.out.println("thread using Runnable interface is started name: "+threadUsingRunnable.getName());


        //3. Thread Class const. Thread(String Name)
        Thread threadUsingNameConstructor= new Thread("threadUsingNameConstructor");
        threadUsingNameConstructor.start();
        System.out.println("thread using Thread(String Name) is started name: "+threadUsingNameConstructor.getName());

        //4. Thread Class const. Thread(Runnable r,String Name)
        MyRunnable myRunnable2 =new MyRunnable();
        Thread threadUsingRunnableAndNameConstructor= new Thread(myRunnable2,"threadUsingRunnableAndNameConstructor");
        threadUsingRunnableAndNameConstructor.start();
        System.out.println("thread using Thread(Runnable r,String Name) is started name: "+threadUsingRunnableAndNameConstructor.getName());

    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread MyThread is running.... getState : "+this.getState()+"; name : "+this.getName());
    }
}

 class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread using MyRunnable is running....");
    }
}

