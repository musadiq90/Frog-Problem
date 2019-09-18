package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class treeClass {

    int[] ar = {1, 1, 1, 0, 2, 2, 2};
    Node root = new Node(ar, null);

    void addChild(Node parent, int ar[], int i, int j) {
        int arr[] = new int[ar.length];
        System.arraycopy(ar, 0, arr, 0, ar.length);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Node n = new Node(arr, parent);
        if (!check(n)) {
            n.pos =pos;
            pos++;
            parent.addchild(n);
        } else {
        }
    }
    int pos=1;
    boolean check(Node n) {
        boolean y = false;
        Node temp = n;
        while (temp.parent != null) {
            temp = temp.parent;
            if (Arrays.equals(temp.arr, n.arr)) {
                y = true;
                break;
            }
        }
        return y;
    }

    int j = 0;

    void populate(Node temp) {
        j++;
        child(temp);
        if (temp.child.isEmpty()) {
            return;
        }
        for (int i = 0; i < temp.child.size(); i++) {
            populate(temp.child.get(i));
        }

    }

    void child(Node parent) {
        int[] arr = parent.arr;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                i = j;
            }
        }
        int len = arr.length;
        if (i == 0) {
            if (arr[1] == 2) {
                addChild(parent, arr, 0, 1);
            }
            if (arr[2] == 2) {
                addChild(parent, arr, 0, 2);
            }
        } else if (i == len - 1) {
            if (arr[len - 2] == 1) {
                addChild(parent, arr, len - 1, len - 2);
            }
            if (arr[len - 3] == 1) {
                addChild(parent, arr, len - 1, len - 3);
            }
        } else if (i == 1) {
            if (arr[0] == 1) {
                addChild(parent, arr, 1, 0);
            }
            if (arr[2] == 2) {
                addChild(parent, arr, 1, 2);
            }
            if (arr[3] == 2) {
                addChild(parent, arr, 1, 3);
            }
        } else if (i == len - 2) {
            if (arr[len - 1] == 2) {
                addChild(parent, arr, len - 2, len - 1);
            }
            if (arr[len - 3] == 1) {
                addChild(parent, arr, len - 2, len - 3);
            }
            if (arr[len - 4] == 1) {
                addChild(parent, arr, len - 2, len - 4);
            }
        } else {
            if (arr[i + 1] == 2) {
                addChild(parent, arr, i, i + 1);
            }
            if (arr[i + 2] == 2) {
                addChild(parent, arr, i, i + 2);
            }
            if (arr[i - 1] == 1) {
                addChild(parent, arr, i, i - 1);
            }
            if (arr[i - 2] == 1) {
                addChild(parent, arr, i, i - 2);
            }
        }

    }
    int count = 0;
    Node fastest;
    int[] res = {2,2,2,0,1,1,1};
    void traversetree(Node temp) {
//        System.out.println(Arrays.toString(temp.arr));
        if (Arrays.equals(temp.arr, res)) {
            fastest = temp;
        }
        count++;
        if (temp.child.isEmpty()) {
            return;
        }
        for (int i = 0; i < temp.child.size(); i++) {

            traversetree(temp.child.get(i));

        }
    }

    void tra(Node temp) {

        if (temp.child.isEmpty()) {
            return;
        }

        from.add(temp);
        for (int i = 0; i < temp.child.size(); i++) {
            to.add(temp.child.get(i));
        }
        for (int i = 0; i < temp.child.size(); i++) {

            tra(temp.child.get(i));

        }
    }

    void fast(Node temp){
        if(temp==null)
            return;
//        Node temp = fastest;


        fast(temp.parent);
        System.out.println(Arrays.toString(temp.arr));
    }


    ArrayList<Node> from = new ArrayList<>();
    ArrayList<Node> to = new ArrayList<>();


}
