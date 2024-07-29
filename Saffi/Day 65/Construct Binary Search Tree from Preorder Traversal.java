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
        return task(preorder, 0, preorder.length - 1);
    }

    static TreeNode task(int[] preorder, int start, int end) {

        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[start]);

        if(start == end) return node;

        int firstGreater = Integer.MAX_VALUE;

        for(int i = start; i <= end; i++) {
            if(preorder[i] > preorder[start]) {
                firstGreater = i;
                break;
            }
        }
        
        node.left = task(preorder, start + 1, Math.min(firstGreater - 1, end));
        node.right = task(preorder, firstGreater, end);

        return node;
    }
}