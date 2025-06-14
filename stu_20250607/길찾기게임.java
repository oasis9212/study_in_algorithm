package stu_20250607;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길찾기게임 {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(sol_load(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}})));
    }

    private static int[][] sol_load(int[][] nodeinfo) {

        int[][] ary = new int[nodeinfo.length][3];
        for (int i = 0; i < nodeinfo.length; i++) {
            ary[i][0] = nodeinfo[i][0];
            ary[i][1] = nodeinfo[i][1];
            ary[i][2] = i + 1;
        }

        Arrays.sort(ary, Comparator.comparingInt((int[] a) -> a[1]).reversed());

        Node_load firstNode = new Node_load(ary[0][2], ary[0][0], ary[0][1]);

        for (int i = 1; i < ary.length; i++) {
            insertNode(firstNode, new Node_load(ary[i][2], ary[i][0], ary[i][1]));
        }

        int[] preorder = new int[nodeinfo.length];
        int[] postorder = new int[nodeinfo.length];
        int[] idx={0};
        gopreorder(firstNode,preorder,idx);
        idx[0]=0;
        gopostorder(firstNode,postorder,idx);
        return new int[][]{preorder,postorder};
    }

    private static void gopostorder(Node_load node, int[] postorder, int[] idx) {
        if(node ==null){
            return;
        }
        gopostorder(node.left,postorder,idx);
        gopostorder(node.right,postorder,idx);
        postorder[idx[0]++]= node.val;

    }

    private static void gopreorder(Node_load node, int[] preorder,int[] idx) {
        if(node == null){
            return;
        }
        preorder[idx[0]++] = node.val;
        gopreorder(node.left,preorder,idx);
        gopreorder(node.right,preorder,idx);

    }

    private static void insertNode(Node_load firstNode, Node_load nodeLoad) {
        if (nodeLoad.x < firstNode.x) {
            if (firstNode.left == null) {
                firstNode.left = nodeLoad;
            } else {
                insertNode(firstNode.left, nodeLoad);
            }
        } else {
            if (firstNode.right == null) {
                firstNode.right = nodeLoad;
            } else {
                insertNode(firstNode.right, nodeLoad);
            }
        }

    }


}

class Node_load {

    int val; // 숫자
    int x;  // x의 위치
    int y;
    Node_load left;
    Node_load right;

    public Node_load(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }
}