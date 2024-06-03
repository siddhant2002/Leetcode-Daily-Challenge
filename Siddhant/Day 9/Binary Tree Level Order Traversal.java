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
        List<List<Integer>> nm=new ArrayList<>();
        if(root==null)
        {
            return nm;
        }
        Queue<TreeNode> kk=new LinkedList<>();
        kk.add(root);
        while(!kk.isEmpty())
        {
            int size=kk.size();
            List<Integer> k=new ArrayList<>();
            for(int i=1;i<=size;i++)
            {
                if(kk.peek().left!=null)
                {
                    kk.offer(kk.peek().left);
                }
                if(kk.peek().right!=null)
                {
                    kk.offer(kk.peek().right);
                }
                k.add(kk.poll().val);
            }
            nm.add(new ArrayList<>(k));
        }
        return nm;
    }
}