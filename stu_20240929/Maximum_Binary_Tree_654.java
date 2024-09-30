package stu_20240929;

// https://leetcode.com/problems/maximum-binary-tree/
public class Maximum_Binary_Tree_654 {

    public static void main(String[] args) {
        int[] nums={3,2,1,6,0,5};
     //   TreeNode t=   sol(nums);
        // 다른 풀이.
        TreeNode t2=   t(nums, 0, nums.length);
        

        
    }

    private static TreeNode t(int[] nums, int l, int r) {
        int maxIdx = l;

        if(l >= r) {
            return null;
        }
        for(int i = l+1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = t(nums, l, maxIdx);
        node.right = t(nums, maxIdx+1, r);
        return node;
    }

    static TreeNode sol(int[] nums) {

        TreeNode root=null;

        for (int i = 0; i < nums.length; i++) {
            TreeNode r= new TreeNode(nums[i],null,null);
            root=sorting(root,r);
        }
        return root;
    }

    private static TreeNode sorting(TreeNode root, TreeNode r) {
        if(root==null){
            root=r;
            return root;
        }
        if(root.val > r.val){
            root.right=sorting(root.right, r);

        }else{
            TreeNode temp=root;
            root=r;
            root.left=temp;

        }

        return  root;
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
