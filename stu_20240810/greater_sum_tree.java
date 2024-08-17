package stu_20240810;

import java.util.ArrayList;
import java.util.List;

public class greater_sum_tree {
    public static void main(String[] args) {
        int[] nodeori = {4, 1, 6, 0, 2, 5, 7, -1, -1, -1, 3, -1, -1, -1, 8};  // -1  == null

        TreeNode root = new TreeNode(nodeori[0]);
        for (int i = 1; i < nodeori.length; i++) {
            if(nodeori[i]==-1) continue;
            root.add(nodeori[i]);
        }
        // 식만들기.


        List<TreeNode> list= new ArrayList<>();
        addOrder(list,root);

        int count=0;
        for (TreeNode node: list){
            count+=node.val;
            node.val=count;
        }

    }

    private static void addOrder(List<TreeNode> list, TreeNode current) {

        if (current.right!=null){
            addOrder(list,current.right);
        }
        list.add(current);
        if( current.left!=null){
            addOrder(list,current.left);
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

    void add(int newval) {
        if (val > newval) {
            if(this.left ==null){
                this.left = new TreeNode(newval);
            }else{
                this.left.add(newval);
            }
        } else {
            if(this.right ==null){
                this.right = new TreeNode(newval);
            }else{
                this.right.add(newval);
            }
        }
    }
}