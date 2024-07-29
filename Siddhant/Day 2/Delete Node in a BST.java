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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        {
            return root;
        }
        TreeNode head=root;
        if(root.val==key)
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            TreeNode left=root.left;
            root=root.right;
            while(root.left!=null)
            {
                root=root.left;
            }
            root.left=left;
            return head.right;
        }
        while(root!=null)
        {
            if(root.left!=null && root.left.val==key)
            {
                TreeNode left=root.left.left;
                TreeNode right=root.left.right;
                if(right==null)
                {
                    root.left=left;
                    break;
                }
                if(left==null)
                {
                    root.left=right;
                    break;
                }
                TreeNode ptr=right;
                for(; ptr.left!=null; ptr=ptr.left);
                ptr.left=left;
                root.left=right;
            }
            else if(root.right!=null && root.right.val==key)
            {
                TreeNode left=root.right.left;
                TreeNode right=root.right.right;
                if(right==null)
                {
                    root.right=left;
                    break;
                }
                if(left==null)
                {
                    root.right=right;
                    break;
                }
                TreeNode ptr=right;
                for(; ptr.left!=null; ptr=ptr.left);
                //System.out.println(right.val);
                ptr.left=left;
                root.right=right;
            }
            if(key>root.val)
            {
                root=root.right;
            }
            else
            {
                root=root.left;
            }
        }
        return head;
    }
}