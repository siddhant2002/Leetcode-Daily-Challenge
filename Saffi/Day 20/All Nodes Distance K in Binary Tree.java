/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();

        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node.left != null) {
                q.offer(node.left);

                map.put(node.left, node);
            }
            if(node.right != null) {
                q.offer(node.right);

                map.put(node.right, node);
            }
        }

        List<Integer> ans = new ArrayList<>();

        Set<TreeNode> vis = new HashSet<>();

        preorder(target, k, ans, map, vis);

        return ans;
    }

    static void preorder(TreeNode node, int k, List<Integer> ans, Map<TreeNode, TreeNode> map, Set<TreeNode> vis) {
        if(k == 0) {
            ans.add(node.val);
            return;
        }

        vis.add(node);

        if(!vis.contains(node.left) && node.left != null) {
            preorder(node.left, k - 1, ans, map, vis);
        }

        if(!vis.contains(node.right) && node.right != null) {
            preorder(node.right, k - 1, ans, map, vis);
        }

        if(map.containsKey(node) && !vis.contains(map.get(node))) {
            preorder(map.get(node), k - 1, ans, map, vis);
        }
    }
}