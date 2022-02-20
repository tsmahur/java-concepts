package com.ds;

public class Queue<T> {
    //using Array - limited size
/*    private int front;
    private int rear;
    private int maxSize;
    private String[] arr;
//    private T[] arr;
    Queue(int maxSize){
        front=0;
        rear=-1;
        this.maxSize=maxSize;
//        this.arr=new T[maxSize];//not allowed
        this.arr=new String[maxSize];
    }*/

    //using Node - size not limited
    private Node<T> head;
    private Node<T> tail;

    public boolean add(T data) { //addAtEnd //enqueue
        Node<T> node = new Node<>(data);
        if (tail != null) {
            tail.setNext(node);
//            tail = node;
        }
        tail = node;
        if (head == null) {
//            head = tail = node;
            head = node;
        }
        return true;//in case of Array false need to send if array is full, here this not the case
    }

    public boolean addAtBeginning(T data) {
        Node<T> node = new Node<>(data);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
        return true;//in case of Array false need to send if array is full, here this not the case
    }

    public void display() {
        System.out.println("--Printing Queue Data--");
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }

    public T remove() {//from beginning //dequeue
        if(head!=null) {
            T data = head.getData();
            head = head.getNext();
            if (head == null) tail = null;
            return data;
        }
        else return null;
    }


}
