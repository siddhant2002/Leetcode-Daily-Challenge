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
    static int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;

        task(root);

        return ans;
    }

    static int task(TreeNode root) {
        if(root == null) return 0;

        // To eliminate negative sum path
        int leftSum = Math.max(0, task(root.left));
        int rightSum = Math.max(0, task(root.right));

        ans = Math.max(ans, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}