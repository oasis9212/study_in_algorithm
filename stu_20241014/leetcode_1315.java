package stu_20241014;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1315 {

    public static void main(String[] args) {

        Integer[] ary = {6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        TreeNode rootNode = createTree(ary);


         int a=sol(rootNode,null,null);
        System.out.println(a);



    }

    private static int sol(TreeNode node,TreeNode parent, TreeNode grand) {
        int total=0;
        if(grand!=null && grand.val%2==0){
            total+=node.val;
        }
        if(node.left!=null){
            total+= sol(node.left, node, parent);
        }
        if(node.right!=null){
            total+=sol(node.right, node, parent);
        }

        return total;



    }

    public static TreeNode createTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) return null;
        return helper(nodes, 0);
    }
    private static TreeNode helper(Integer[] nodes, int i) {
        if (i >= nodes.length || nodes[i] == null) return null;

        TreeNode node = new TreeNode(nodes[i]);
        node.left = helper(nodes, 2 * i + 1);
        node.right = helper(nodes, 2 * i + 2);

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