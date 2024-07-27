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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode a[]=new TreeNode[1];
        task(root,val,a);
        return a[0];
        
    }
    private void task(TreeNode root, int val, TreeNode a[])
    {
        if(root==null)
        {
            return;
        }
        if(root.val==val)
        {
            a[0]=root;
            return;
        }
        if(root.val < val)
        {
            task(root.left,val,a);
        }
        else
        {
            task(root.right,val,a);
        }
    }
}