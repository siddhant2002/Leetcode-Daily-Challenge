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
        if(root == null) return null;

        return task(root, key);
    }

    static TreeNode task(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) {
            if(root.left == null && root.right == null) return null;

            if(root.left != null) {
                TreeNode temp = root.left;

                while(temp.right != null) {
                    temp = temp.right;
                }

                temp.right = root.right;

                return root.left;
            }
            else {
                TreeNode temp = root.right;

                while(temp.left != null) {
                    temp = temp.left;
                }

                temp.left = root.left;

                return root.right;
            }

        }
        else if(root.val > key) {
            root.left = task(root.left, key);
        }
        else {
            root.right = task(root.right, key);
        }

        return root;
    }
}
