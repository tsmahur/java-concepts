package com.handson.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array={1,7,2,9,3,12,8,17};
        System.out.println("linearSearch : 9 :"+linearSearch(array,9));
        System.out.println("linearSearch : 10 :"+linearSearch(array,10));
    }

    private static boolean linearSearch(int[] array, int searchElement) {
        for (int current : array) {
            if(current==searchElement) return true;
        }
        return false;
    }
}
