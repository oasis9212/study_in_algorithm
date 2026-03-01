package stu_20260219;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_1305 {
    public static void main(String[] args) {

        Integer[] num1 = {2, 1, 4};
        Integer[] num2 = {1, 0, 3};

        TreeNode root1 = buildTree(num1);
        TreeNode root2 = buildTree(num2);


        System.out.println(sol_1305(root1, root2));
    }

    private static List<Integer> sol_1305(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        inorder(root1, r1);
        inorder(root2, r2);

        int r1len = 0;
        int r2len = 0;

        List<Integer> result= new ArrayList<>();
        while (r1len < r1.size() && r2len < r2.size()) {
            if(r1.get(r1len)<r2.get(r2len)){
                result.add(r1.get(r1len++));
            }else{
                result.add(r2.get(r2len++));
            }
        }

        while(r1len< r1.size()) result.add(r1.get(r1len++));
        while(r2len< r2.size()) result.add(r2.get(r2len++));


        return result;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static TreeNode buildTree(Integer[] arr) {
        return build(arr, 0, arr.length - 1);
    }

    private static TreeNode build(Integer[] arr, int left, int right) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // 왼쪽 자식
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // 오른쪽 자식
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
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

