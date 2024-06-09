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
    public int kthSmallest(TreeNode root, int k) {
        int a[]=new int[2];
        task(root,k,a);
        return a[1];
    }
    void task(TreeNode root, int k, int a[])
    {
        if(root==null)
        {
            return;
        }
        task(root.left,k,a);
        a[0]+=1;
        if(a[0]==k)
        {
            a[1]=root.val;
            return;
        }
        task(root.right,k,a);
    }
}