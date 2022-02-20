package com.operators;

public class BitwiseAndShift {
    public static void main(String[] args){

        System.out.println("---------------Bitwise--------------");
        int x=5;
        int y=7;
        System.out.println("x = "+x+" -> "+Integer.toBinaryString(x));
        System.out.println("y = "+y+" -> "+Integer.toBinaryString(y));
        System.out.println("x|y = "+(x|y) );
        System.out.println("x&y = "+(x&y) );
        System.out.println("x^y = "+(x^y) ); //same bit -> 0 , different bit -> 1
        System.out.println("x = "+x+" , so ~x = "+(~x) ); //2's complement

        System.out.println("---------------Shift--------------");
        int a=10;
        int b=-10;
        int shift=1;
        System.out.println("a = "+a+" -> "+Integer.toBinaryString(x));
        System.out.println("b = "+b+" -> "+Integer.toBinaryString(y));
        System.out.println("Left (+ve) : "+a+"<<"+shift+" = "+(a<<shift));
        System.out.println("Left (-ve) : "+b+"<<"+shift+" = "+(b<<shift));
        System.out.println("Signed Right (+ve) : "+a+">>"+shift+" = "+(a>>shift));
        System.out.println("Signed Right (-ve) : "+b+">>"+shift+" = "+(b>>shift));
        System.out.println("UnSigned Right (+ve) : "+a+">>>"+shift+" = "+(a>>>shift));
        System.out.println("UnSigned Right (-ve) : "+b+">>>"+shift+" = "+(b>>>shift));
    }
}
