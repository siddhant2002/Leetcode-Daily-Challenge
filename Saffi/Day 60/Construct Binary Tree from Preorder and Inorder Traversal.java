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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return task(0, inorder.length - 1, 0, preorder, inorder);
    }

    static TreeNode task(int start, int end, int pos, int[] preorder, int[] inorder) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[pos]);

        int newPos = 0;

        for(newPos = 0; newPos < inorder.length; newPos++) {
            if(inorder[newPos] == preorder[pos]) {
                break;
            }
        }

        int size = newPos - start;

        node.left = task(start, newPos - 1, pos + 1, preorder, inorder);

        node.right = task(newPos + 1, end, pos + 1 + size, preorder, inorder);

        return node;
    }
}