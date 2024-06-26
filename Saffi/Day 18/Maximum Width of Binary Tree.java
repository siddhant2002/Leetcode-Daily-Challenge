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
class Pair {
    int pos;
    TreeNode node;
    Pair(TreeNode n, int p) {
        pos = p;
        node = n;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int ans = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            int firstPos = 0, lastPos = 0;

            for(int i = 0; i < size; i++) {
                TreeNode n = q.peek().node;
                int p = q.peek().pos;

                if(i == 0) firstPos = p;

                if(i == size - 1) lastPos = p;

                q.poll();

                if(n.left != null) q.offer(new Pair(n.left, 2 * p + 1));
                if(n.right != null) q.offer(new Pair(n.right, 2 * p + 2));
            }

            ans = Math.max(lastPos - firstPos + 1, ans);
        }

        return ans;
    }
}