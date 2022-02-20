package com.ds;

public class BinaryNode {
    private BinaryNode left,right;
    private int data;
    public BinaryNode(int data){
        this.data=data;//root node
    }
    public void insert(int data){
//        BinaryNode binaryNode=new BinaryNode(data); //will take memory for each node, sor directly initialize left/right
        if(this.data<=data){
            if(left==null) left=new BinaryNode(data);
            else left.insert(data);
        }
        else{
            if(right==null) right=new BinaryNode(data);
            else right.insert(data);
        }
    }
    public boolean contains(int data){
        if(this.data==data) return true;
//        if(this.data<=data){
        if(this.data<data){
            if(left==null) return false;
            else return left.contains(data);
        }
        else{
            if(right==null) return false;
            else return right.contains(data);
        }
    }
    
    public void displayInOrder(){// left - root - right
        if(this.left!=null) left.displayInOrder(); //left
        System.out.println(this.data); //root
        if(this.right!=null) right.displayInOrder(); //right
    }
    public void displayPreOrder(){//  root - left - right
        System.out.println(this.data); //root
        if(this.left!=null) left.displayInOrder(); //left
        if(this.right!=null) right.displayInOrder(); //right
    }
    public void displayPostOrder(){// left - right - root
        if(this.left!=null) left.displayInOrder(); //left
        if(this.right!=null) right.displayInOrder(); //right
        System.out.println(this.data); //root
    }
}
