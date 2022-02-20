package com.ds;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public boolean addAtEnd(T data) { //addAtEnd
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
        return true;
    }

    public boolean addAtEndWithoutTail(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            return true;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
        tail = node;//if tail was not here in this class then this can be removed
        return true;
    }

    public boolean addAtBeginning(T data) {
        Node<T> node = new Node<>(data);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
        if (tail == null) {//this condition can be removed if tail was not there
            tail = node;
        }
        return true;
    }

    public void display() {
        System.out.println("--Printing LinkedList Data--");
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }

    //delete any node
    public boolean remove(T data) { //without tail
        if (head == null) return false;

        //data is at head
        if (head.getData() == data) {//equals() may be used, and also it should be overridden in class if not.
            head = head.getNext();

            //node deleted(skipped) now change tail
            if(head==null){//this condition can be removed if tail was not there
                tail=head;
            }
            return true;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData() == data) {//if the required data is next node of current
                currentNode.setNext(currentNode.getNext().getNext());//skipping next node to be deleted i.e, required deletion node

                //node deleted(skipped) now change tail
                if(currentNode.getNext()==null){//it means data is at tail//this condition can be removed if tail was not there
                    tail=currentNode;
                }
                return true;
            }
        currentNode=currentNode.getNext();
        }

        return false;
    }

    public T remove() {//from beginning
        if (head != null) {
            T data = head.getData();
            head = head.getNext();
            if (head == null) tail = null;
            return data;
        } else return null;
    }

    //search any node
    //insert after/before any node
}
