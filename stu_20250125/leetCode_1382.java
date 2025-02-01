package stu_20250125;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode_1382 {
    public static void main(String[] args) {
        Integer[] ary={1,null,2,null,3,null,4,null,null};

        TreeNode root = new TreeNode(ary[0]);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int i=1;
        while (i<ary.length){
            TreeNode cur =qu.poll();
            if(ary[i]!=null){
                cur.left = new TreeNode(ary[i]);
                qu.add(cur.left);
            }
            i++;
            if(ary[i]!=null){
                cur.right = new TreeNode(ary[i]);
                qu.add(cur.right);
            }
            i++;
        }

        TreeNode ans=sol(root);

        System.out.println(ans);

    }

    private static TreeNode sol(TreeNode root) {
        List<Integer> numlist=new ArrayList<>();
        inOrderNum(root,numlist);
        return sortingTree(numlist,0,numlist.size()-1);

    }

    private static TreeNode sortingTree(List<Integer> numlist, int start, int end) {
        if(start> end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode n=new TreeNode(numlist.get(mid));
        n.left = sortingTree(numlist,start,mid-1);
        n.right= sortingTree(numlist,mid+1,end);
        return n;
    }

    private static void inOrderNum(TreeNode n, List<Integer> numlist) {
        if(n==null) return;
        inOrderNum(n.left,numlist);
        numlist.add(n.val);
        inOrderNum(n.right,numlist);

    }


}


class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }


      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
