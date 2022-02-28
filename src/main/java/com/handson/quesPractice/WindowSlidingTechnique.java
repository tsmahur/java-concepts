package com.handson.quesPractice;

public class WindowSlidingTechnique {
    public static void main(String[] args) {
        int[] array={1,4,-1,0,3,8};
        int winSize=2;  //window size
        System.out.println(" Window sum for windowSize:"+winSize+" is :"+windowSum(array,winSize));

    }

    private static int   windowSum(int[] array,int winSize) {

        int sum=0; // to store window sum
        int max=Integer.MIN_VALUE;
        if(winSize>array.length) return 0; //or invalid scenario
        //first window sum
        for (int i = 0; i < winSize; i++) {
            sum+=array[i];
        }
        max=Math.max(sum,max);
        for (int i = winSize; i < array.length; i++) {
            sum=sum+array[i]-array[i-winSize]; //add next, remove previous from window sum
            max=Math.max(sum,max);
        }

        return max;
    }
}
