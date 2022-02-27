package com.ds;

public class QueueUsingStack<T> {
    private Stack<T> newOnTop=new Stack<>(); //using custom (com.ds.Stack), can also use java.util
    private Stack<T> oldOnTop=new Stack<>();
    public boolean enqueue(T data){//add new element
        return newOnTop.push(data);
    }
    public T dequeue(){//remove oldest element
        shiftStacks();//shift from new if old is empty
        return oldOnTop.pop();
    }
    public T peek(){//get oldest element
        shiftStacks();//shift from new if old is empty
        return oldOnTop.peek();
    }
    public void shiftStacks() {
        if(oldOnTop.isEmpty()){
            while(!newOnTop.isEmpty()) oldOnTop.push(newOnTop.pop());
        }
    }
}
