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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++)
        {
            insert(root,preorder[i]);
        }
        return root;
    }
    private void insert(TreeNode root, int val)
    {
        if(root==null)
        {
            return;
        }
        if(val < root.val && root.left==null)
        {
            root.left=new TreeNode(val);
            return;
        }
        if(val > root.val && root.right==null)
        {
            root.right=new TreeNode(val);
            return;
        }
        if(val < root.val)
        {
            insert(root.left,val);
        }
        else
        {
            insert(root.right,val);
        }
    }
}