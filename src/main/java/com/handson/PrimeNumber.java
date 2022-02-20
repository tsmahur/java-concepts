package com.handson;

public class PrimeNumber {
    public static void main(String[] args) {
        for(int i=1;i<100;i++){
            if(isPrime(i)) System.out.println(i);
        }
    }
    public static boolean isPrime(int num){
        if(num==0 || num==1 ) return false;
        for(int i=2;i<num/2;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
