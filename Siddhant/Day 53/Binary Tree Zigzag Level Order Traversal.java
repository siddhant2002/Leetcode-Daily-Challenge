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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Queue<TreeNode> nm=new LinkedList<>();
        nm.offer(root);
        boolean flag=true;
        while(!nm.isEmpty())
        {
            int size=nm.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=1;i<=size;i++)
            {
                if(nm.peek().left!=null)
                {
                    nm.offer(nm.peek().left);
                }
                if(nm.peek().right!=null)
                {
                    nm.offer(nm.peek().right);
                }
                if(flag)
                {
                    temp.add(nm.poll().val);
                }
                else
                {
                    temp.add(0,nm.poll().val);
                }
            }
            flag=!flag;
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}