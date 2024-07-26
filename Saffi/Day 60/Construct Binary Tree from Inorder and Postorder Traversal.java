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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return task(0, inorder.length - 1, postorder.length - 1, postorder, inorder);
    }

    static TreeNode task(int start, int end, int pos, int[] postorder, int[] inorder) {
        if(start > end) return null;

        TreeNode node = new TreeNode(postorder[pos]);

        int newPos = 0;

        for(newPos = 0; newPos < inorder.length; newPos++) {
            if(inorder[newPos] == postorder[pos]) {
                break;
            }
        }

        int size = end - newPos;

        node.left = task(start, newPos - 1, pos - 1 - size, postorder, inorder);

        node.right = task(newPos + 1, end, pos - 1, postorder, inorder);

        return node;
    }
}