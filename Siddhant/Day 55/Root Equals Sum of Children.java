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
    public boolean checkTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
        {
            return true;
        }
        else if(root.left==null || root.right==null)
        {
            if(root.left==null && root.val!=root.right.val)
            {
                return false;
            }
            else if(root.right==null && root.val!=root.left.val)
            {
                return false;
            }
        }
        return root.val==(root.left.val+root.right.val) && checkTree(root.left) && checkTree(root.right);
    }
}