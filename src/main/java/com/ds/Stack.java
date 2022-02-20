package com.ds;

public class Stack<T> {
    //using Array - limited size
/*    int top,maxSize;
    int[] arr;
    Stack(int maxSize){
        top=0;
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }*/

    //using Node - size not limited
    private Node<T> top;

    public boolean push(T data){
        Node<T> node=new Node<>(data);
//        if(top==null) top=node;
        node.setNext(top);
        top=node;
        return true;//in case of Array false need to send if array is full, here this not the case
    }
    public T pop(){
        if(top!=null) {
            T data = top.getData();
            top=top.getNext();
            return data;
        }else return null;
    }
    public void display() {
        System.out.println("--Printing Stack Data--");
        Node<T> tempNode = top;
        while (tempNode != null) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }

}
