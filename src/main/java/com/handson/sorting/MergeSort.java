package com.handson.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        //Divide and Conquer Approach
//        int[] array={4,1,9,3,6,3,9,0};
//        int[] array={4,1,9,3,6,3,9,-1};
        int[] array={4,1,9,3,6,3,9,0,-1};
//        int[] array={4,1,9,3,6,3,9,0,8};
//        int[] array={4,1,9,3};
//        int[] array={4,1,2};
//        int[] array={4,1,2,9,8};
        mergeSortAsc(array);
        System.out.println("mergeSortAsc : "+ Arrays.toString(array));
    }

    public static void mergeSortAsc(int[] array) {
//        mergeSortAsc(array,0,array.length-1);
        mergeSortAsc(array,array.length);//size
    }
    public static void mergeSortAsc(int[] array,int size) {
//    public static void mergeSortAsc(int[] array,int low,int high) {
        if(size<=1) return;//in case of single element return as can not divide further
        int mid=(size)/2;
//        if(low>=high) return;
//        int mid=(low+high)/2;
        //high is size-1

        //copy left and right - this can be avoided by passing temporary array,low,high to this method
        int[] leftArray=new int[mid];
//        int[] rightArray=new int[high-mid+1];
        int[] rightArray=new int[size-mid];
        for (int i = 0; i < mid; i++) { leftArray[i]=array[i];}
//        for (int i = mid; i <=high; i++) { rightArray[i-mid]=array[i];}
        for (int i = mid; i <size; i++) { rightArray[i-mid]=array[i];}
//        System.arraycopy(array, 0, leftArray, 0, mid);

        mergeSortAsc(leftArray,mid);
        mergeSortAsc(rightArray,size-mid);
        mergeHalvesAsc(array,leftArray,rightArray,mid,size-mid);

//        mergeSortAsc(leftArray,low,mid-1);
//        mergeSortAsc(rightArray,mid+1,high);
//        mergeHalvesAsc(array,leftArray,rightArray,mid,high-mid+1);
    }

    public static void mergeHalvesAsc(int[] array, int[] leftArray, int[] rightArray, int leftArraySize, int rightArraySize) {
        int leftIndex=0,rightIndex=0,mergedIndex=0;
        //sorting and merging
        while(leftIndex<leftArraySize && rightIndex<rightArraySize){
            if (leftArray[leftIndex]<=rightArray[rightIndex]) array[mergedIndex++]=leftArray[leftIndex++];
            else array[mergedIndex++]=rightArray[rightIndex++]; //leftArray[leftIndex]>rightArray[rightIndex]
        }
        //adding remaining - none or either of one will have an effect at a time
        while(leftIndex<leftArraySize) array[mergedIndex++]=leftArray[leftIndex++];
        while(rightIndex<rightArraySize) array[mergedIndex++]=rightArray[rightIndex++];
    }
}
