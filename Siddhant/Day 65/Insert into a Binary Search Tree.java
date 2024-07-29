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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
        {
            return new TreeNode(val);
        }
        task(root,val);
        return root;
    }
    private void task(TreeNode root, int val)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null || root.right==null)
        {
            if(root.val > val && root.left==null)
            {
                root.left=new TreeNode(val);
                return;
            }
            else if(root.val < val && root.right==null)
            {
                root.right=new TreeNode(val);
                return;
            }
        }
        if(val < root.val)
        {
            task(root.left,val);
        }
        else
        {
            task(root.right,val);
        }
    }
}