/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean flag[]=new boolean[1];
        flag[0]=true;
        int val=task(root,flag);
        return flag[0];
    }
    private int task(TreeNode root, boolean flag[])
    {
        if(root==null)
        {
            return 0;
        }
        int left=1+task(root.left,flag);
        int right=1+task(root.right,flag);
        if(Math.abs(left-right)>1)
        {
            flag[0]=false;
        }
        return Math.max(left,right);
    }
}