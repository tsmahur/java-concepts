package com.multiThreading.synchronization;

public class InterThreadCommunication {
    public static void main(String[] args) {
        final MyClass myClass=new MyClass();
        new Thread(myClass::method1).start(); //() -> myClass.method1()
        new Thread(myClass::method2).start();
    }
}
class MyClass {
    boolean flag=true;
    synchronized void method1(){
        System.out.println("inside method1() - START");
        if(flag){
            System.out.println("waiting for method2()");
            try{wait();}catch(Exception e){}
            System.out.println("waiting for method2() over");
        }
        System.out.println("inside method1() - END");
    }

    synchronized void method2(){
        System.out.println("inside method2() - START");
        flag=false;
        try{Thread.sleep(2000);}catch(Exception e){}
        System.out.println("calling notify() inside method2()");
        notify();
        System.out.println("calling done notify(); inside method2() - END");

    }
}