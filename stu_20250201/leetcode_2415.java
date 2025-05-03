package stu_20250201;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2415 {
    public static void main(String[] args) {
        sol_(new int[]{2, 3, 5, 8, 13, 21, 34});
    }

    private static void sol_(int[] ints) {

        TreeNode root = TreeMakeer(ints);
        change(root.left,root.right,0);

        System.out.println("asd");

    }

    private static void change(TreeNode left,TreeNode right, int idx) {
       if(left==null || right ==null){
           return;
       }
        if(idx%2==0){
            int temp = left.val;
            left.val= right.val;
            right.val=temp;
        }

        change(left.left,right.right,idx+1);
        change(left.right,right.left,idx+1);


    }

    private static TreeNode TreeMakeer(int[] ints) {
        if (ints == null || ints.length == 0) return null;
        return createTreeHelper(ints, 0);
    }

    private static TreeNode createTreeHelper(int[] ints, int idx) {
        if (idx >= ints.length) return null;

        TreeNode node = new TreeNode(ints[idx]);
        node.left = createTreeHelper(ints, 2 * idx + 1);
        node.right = createTreeHelper(ints, 2 * idx + 2);

        return node;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
