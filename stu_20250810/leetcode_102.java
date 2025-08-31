package stu_20250810;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102 {
    public static void main(String[] args) {
        System.out.println(sol_102(new Object[]{3, 9, 20, null, null, 15, 7}));
    }

    private static List<List<Integer>> sol_102(Object[] objects) {

        Integer[] arr = {};
        TreeNode root = buildTree(arr);


        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Queue<TreeNode> t= new LinkedList<>();
        t.add(root);
        int qsize=t.size();
        while (!t.isEmpty()){
            List<Integer> len=new ArrayList<>();
            for (int i = 0; i < qsize; i++) {
                TreeNode s=t.poll();
                len.add(s.val);
                if(s.left!=null){
                    t.add(s.left);
                }
                if(s.right!=null){
                    t.add(s.right);
                }
            }
            qsize=t.size();
            ans.add(len);
        }



        return ans;
    }

    public static TreeNode buildTree(Integer[] arr) {
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

    // 레벨 순서 출력
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                System.out.print((node != null ? node.val : "null") + " ");
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
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
