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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            List<Integer> temp = new ArrayList<>();

            while(size-- > 0) {
                TreeNode ptr = q.poll();

                temp.add(ptr.val);

                if(ptr.left != null) q.offer(ptr.left);
                if(ptr.right != null) q.offer(ptr.right);
            }

            ans.add(temp);
        }

        return ans;
    }
}