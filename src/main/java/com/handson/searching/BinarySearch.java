package com.handson.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array={1,3,6,9,12,15,17};//sorted array
        System.out.println("binarySearch : "+binarySearch(array,9));
        System.out.println("binarySearchUsingRecursion : "+binarySearchUsingRecursion(array,9));
    }
    public static boolean binarySearch(int[] array,int searchElement){//array must be sorted
        int low=0;
        int high=array.length-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(array[mid]==searchElement) return true;
            else if(array[mid]>searchElement) high=mid-1;
            else low=mid+1; //array[mid]<searchElement
        }
        return false;
    }
    public static boolean binarySearchUsingRecursion(int[] array,int searchElement){
        return binarySearchUsingRecursion(array,searchElement,0, array.length-1);
    }
    public static boolean binarySearchUsingRecursion(int[] array,int searchElement,int low,int high){//array must be sorted
        if(low>high) return false;
        int mid = (low + high) / 2;
        if(array[mid]==searchElement) return true;
        else if(array[mid]>searchElement) return binarySearchUsingRecursion(array,searchElement,low,mid-1);
        else return binarySearchUsingRecursion(array,searchElement,mid+1,high);//array[mid]<searchElement
    }
}
