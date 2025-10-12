package stu_20251006;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_988 {

    public static void main(String[] args) {
        // Integer[] ary = {0, 1, 2, 3, 4, 3, 4};
        Integer[] ary = {2, 2, 1, null, 1, 0, null, 0};
        TreeNode rootNode = createTree(ary);

        System.out.println(sol_988(rootNode));


    }

    private static String sol_988(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        return backtrack_988(root, sb);
    }

    private static String backtrack_988(TreeNode root, StringBuilder sb) {
        sb.insert(0, (char)('a' + root.val));
        if (root.right == null && root.left == null) {
            return sb.toString();
        }
        String right = null;
        String left = null;

        if (root.right != null) {
            right = backtrack_988(root.right, new StringBuilder(sb));
        }
        if (root.left != null) {
            left = backtrack_988(root.left, new StringBuilder(sb));
        }
        if (right == null) return left;
        if (left == null) return right;

        return compareStr(right, left);

    }

    private static String compareStr(String rightStr, String leftStr) {
        int cmp = rightStr.compareTo(leftStr);
        if (cmp <= 0) {
            return rightStr;
        } else {
            return leftStr;
        }
    }

    public static TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) return null;

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();

            if (i < nodes.length && nodes[i] != null) {
                curr.left = new TreeNode(nodes[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                curr.right = new TreeNode(nodes[i]);
                queue.offer(curr.right);
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