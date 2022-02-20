package com.handson.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array={1,7,2,9,3,12,8,17};
//        int[] array={1,7,2};
        quickSortAsc(array);
        System.out.println("quickSort : "+ Arrays.toString(array));

    }
    public static void quickSortAsc(int[] array){
        quickSortAsc(array,0,array.length-1);
    }
    public static void quickSortAsc(int[] array, int low, int high) {
        if(low>=high) return;
        int mid=(low+high)/2;
        int pivot=array[mid];//it can be any not necessary the mid one
        int index=partition(array,low,high,pivot);
        quickSortAsc(array,low,index-1);
        quickSortAsc(array,index,high);
    }

    public static int partition(int[] array, int low, int high, int pivot) {
        while(low<=high){
            while(array[low]<pivot){
                low++;
            }
            while(array[high]>pivot){
                high--;
            }
            if(low<=high) {
                swap(array,low,high);
                low++;
                high--;
            }
        }
        return low;//partition point
    }

    public static void swap(int[] array, int low, int high) {
        int temp=array[low];
        array[low]=array[high];
        array[high]=temp;
    }
}
