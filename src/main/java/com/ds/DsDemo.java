package com.ds;

public class DsDemo {
    public static void main(String[] args) {
        Queue<Integer>  integerQueue=new Queue<>();//not from java.util
        integerQueue.add(5);//addAtEnd
        integerQueue.add(6);//addAtEnd
        integerQueue.add(8);//addAtEnd
        integerQueue.addAtBeginning(3);
        integerQueue.addAtBeginning(4);
        integerQueue.addAtBeginning(1);
        integerQueue.remove();
        integerQueue.display();
        //--------------------------------------------------
        Stack<Integer> integerStack=new Stack<>();//not from java.util
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.pop();
        integerStack.display();
        //----------------------------------------------------
        LinkedList<Integer> integerLinkedList=new LinkedList<>();//not from java.util
        integerLinkedList.addAtEnd(1);
        integerLinkedList.addAtEnd(2);
        integerLinkedList.addAtEnd(3);
        integerLinkedList.addAtEnd(4);
        integerLinkedList.addAtBeginning(0);
        integerLinkedList.addAtEndWithoutTail(5);
        integerLinkedList.remove();//from beginning
        integerLinkedList.remove(3);
        integerLinkedList.display();
        //------------------------------------------------
        //Binary Search tree
        BinaryNode root=new BinaryNode(11);
        BinaryTree tree=new BinaryTree(root);
        tree.insert(16);
        tree.insert(15);
        tree.insert(9);
        tree.displayInOrder();
        tree.displayPreOrder();
        //---------------------
        BinaryNode rootNode=new BinaryNode(20);
        rootNode.insert(5);
        rootNode.insert(8);
        rootNode.insert(9);
        rootNode.insert(10);
        rootNode.insert(25);
        rootNode.insert(27);
        rootNode.insert(22);
        rootNode.insert(23);

        int searchData=10;
        System.out.println("isContains : "+searchData+" : "+rootNode.contains(searchData));

        System.out.println("----InOrder---");
        rootNode.displayInOrder();
        //---------------------------------------------------------------------
        //min Heap
        //stored in array from left to right each level of tree
        MinHeapNode minHeapNode=new MinHeapNode();
        minHeapNode.add(10);
        minHeapNode.add(20);
        minHeapNode.add(7);
        minHeapNode.add(30);
        minHeapNode.add(1);

        System.out.println("minHeap top element :"+minHeapNode.peek());
        System.out.println("minHeap poll() element :"+minHeapNode.poll());
        System.out.println("minHeap top element :"+minHeapNode.peek());
        //--------------------------------------------------------------


    }
}
