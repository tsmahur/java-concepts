package com.handson.quesPractice;

import java.util.Scanner;

public class PrimeString {

    public static void main(String args[] ) {
        System.out.println("Enter int");
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        scn.skip("(\r\n|[\r\n])");
        String s;
        while(n!=0){
            System.out.println("Enter string :"+n);
            n--;
            s=scn.nextLine();
            System.out.println("Entered string :"+s);
            char[] str=s.toCharArray();
            int even=0;
            int odd=0;
            for(int i=0;i<str.length;i++){
                if(str[i]>96 && str[i]<123){
                    if(i%2==0) odd=odd+str[i];
                    else even=even+str[i];
                }
            }
            int diff=Math.abs(odd-even);
            if(diff%3==0 || diff%5==0 || diff%7==0 )
                System.out.println("Prime String");
            else
                System.out.println("Casual String");
        }
    }

}
