package com.ds;

import java.util.Arrays;

public class MinHeapNode {
    private int capacity = 10; //initial capacity of heap
    int[] items = new int[capacity];
    private int size = 0; //to keep track no of items present in heap

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex-1)/2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index)<size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index)<size; }
    private boolean hasParent(int index) { return getParentIndex(index)>=0; }

    private int leftChild(int index){ return items[getLeftChildIndex(index)]; }
    private int rightChild(int index){ return items[getRightChildIndex(index)]; }
    private int parent(int index){ return items[getParentIndex(index)]; }

    private void growIfNeeded(){
        if(size==capacity){
            capacity=capacity*2;//doubling the capacity
            items= Arrays.copyOf(items,capacity);
        }
    }

    private void swap(int indexOne, int indexTwo){
        int temp =items[indexOne];
        items[indexOne]=items[indexTwo];
        items[indexTwo]=temp;
    }

    public int peek(){//returns top element (minimum)
        if(size==0) throw new IllegalStateException("Size is 0, can't peek on empty Heap");
        return items[0];
    }
    public int poll(){//removes top element and do shifting
        if(size==0) throw new IllegalStateException("Size is 0, can't peek on empty Heap");
        int itemToBeDeleted=items[0];
        items[0]=items[size-1];//setting the last element to top
        size--;
        heapDown(); //now reshuffle the heap to DOWN in order ensure lowest term is at top
        return itemToBeDeleted;
    }

    private void heapDown() {//top was deleted and last was set as top before calling this
        int index=0;//starting with top parent element
        while(hasLeftChild(index)){ //if there is no left child there is no right child so not checking for right here
            int smallerChildIndex=getLeftChildIndex(index);//smaller of left and right child guessing it as left is small
            if(hasRightChild(smallerChildIndex) && rightChild(index)<leftChild(index)){//checking guess is correct or not
                smallerChildIndex=getRightChildIndex(index);//guess was wrong so setting right child as small
            }
            if(items[index]<items[smallerChildIndex]){ //if parent is lesser than both child(smallest of left/right found above) then everything is fine and exit
                break;
            }else{ //parent is greater than with either of child
                swap(index,smallerChildIndex);//so swap the parent with smaller child
                index=smallerChildIndex; //walk down now
            }
        }

    }

    public void add(int item){
        growIfNeeded();
        items[size]=item;//add element to last
        size++;
        heapUp();//now reshuffle the heap to UP in order ensure lowest term is at top
    }

    private void heapUp() {//item added at last  before calling this method
        int index=size-1;//starting with last element
        while(hasParent(index) && parent(index)>items[index]){//walk upward until it is parent and parent is greater than then current
            swap(getParentIndex(index),index);//swap parent with current if its less than parent and has parent
            index=getParentIndex(index);//walk upwards now
        }
    }


}
