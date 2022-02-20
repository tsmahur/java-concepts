package com.handson.quesPractice;

import com.ds.Node;

public class CycleNode {
    public static void main(String[] args) {
        //preparing cycle list
        Node<Integer> node1 = new Node<>(1);//headNode
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        //1->2->3->4->2
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);//cycle to node2

        boolean isCycle = hasCycleInList(node1);//headNode
        System.out.println("isCycle : " + isCycle);

    }

    private static boolean hasCycleInList(Node<Integer> headNode) {
        //make two pointer one is fast other will be slow, if they intersect then it has cycle else not
        Node<Integer> fastNode = headNode;
        Node<Integer> slowNode = headNode;

        while (fastNode != null && slowNode != null) {//if at end either is null, means list is not cyclic
            slowNode = slowNode.getNext();//1st step of slowNode
            fastNode = fastNode.getNext().getNext();//1st step of fastNode
            if (fastNode != null) fastNode = fastNode.getNext();//2nd step of fastNode
            if (slowNode == fastNode) return true;
        }
        return false;
    }
}
