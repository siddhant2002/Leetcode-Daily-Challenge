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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nm=new ArrayList<>();
        task(root,nm);
        return nm;
    }
    private void task(TreeNode root, List<Integer> nm)
    {
        if(root==null)
        {
            return;
        }
        nm.add(root.val);
        task(root.left,nm);
        task(root.right,nm);
    }
}