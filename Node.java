package com.company;


import java.util.ArrayList;

public class Node {
    int pos;
    int[] arr;
    Node parent;
    boolean visited = false;
    ArrayList<Node> child = new ArrayList<>();

    Node(int[] arr, Node parent) {
        this.arr = arr;
        this.parent = parent;
    }

    void addchild(Node n) {
        child.add(n);
    }

    void printchild() {
        for (int i = 0; i < child.size(); i++) {
            int[] arrTemp = child.get(i).arr;
            for (int j = 0; j < arrTemp.length; j++) {
                System.out.print(arrTemp[j] + " ");
            }
            System.out.println("");
        }
    }
    int i = 0;

    Node getchild() {
        Node t = child.get(i);
        i++;
        return t;
    }

}
