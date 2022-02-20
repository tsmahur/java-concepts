package com.ds;

public class BinaryTree {
    BinaryNode root;
    public BinaryTree(BinaryNode root){
        this.root=root;
    }
    public void insert(int data){
        root.insert(data);
    }
    public void displayInOrder(){
        System.out.println("-----Displaying Binary Tree InOrder---");
        root.displayInOrder();
    }
    public void displayPreOrder(){
        System.out.println("-----Displaying Binary Tree  PreOrder---");
        root.displayPreOrder();
    }
    public boolean contains(int data){
        return root.contains(data);
    }
}
