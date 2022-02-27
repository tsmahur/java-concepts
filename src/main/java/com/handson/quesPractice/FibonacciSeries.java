package com.handson.quesPractice;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("----Fibonacci using iteration----");
        fibonacciUsingIteration(10);// noOfTerm>=2
        System.out.println("\n----Fibonacci using recursion : Top-Down----");
        for (int i = 0; i < 10; i++) {
            System.out.print(" "+ fibonacciR(i));
        }
        
    }

    public static void fibonacciUsingIteration(int noOfTerm) {
        int f1=0;
        int f2=1;
        int f3=1;
        System.out.print(" "+f1); // 1st term
        System.out.print(" "+f2); // 2nd term
        for (int i = 3; i <= noOfTerm; i++) { // remaining term
            f3=f2+f1;
            System.out.print(" "+f3);
            f1=f2;
            f2=f3;
        }
    }

    public static int fibonacciR(int num) {
        if(num<=0) return 0;
        if(num==1) return 1;
        return fibonacciR(num-1)+ fibonacciR(num-2);
    }
}
