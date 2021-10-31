package com.multiThreading;

public class ShutDownHook {
    public static void main(String[] args) throws InterruptedException {
        ShutDownThread thread=new ShutDownThread();
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(thread);
        System.out.println(" --- wait program to end or press ctrl + c to end, then hook will be executed");
        Thread.sleep(10000); //1 min
        //enter this command in terminal
        //java src/main/java/com/multiThreading/ShutDownHook.java
        // now press ctrl + c, or wait program to end
        // hook will be executed
    }
}
class ShutDownThread extends Thread{
    @Override
    public void run() {
        System.out.println("--- ShutDownThread hook :: shutting down Bye !!!");
    }
}
