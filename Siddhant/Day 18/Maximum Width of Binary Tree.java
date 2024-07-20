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
class Pair
{
    TreeNode node;
    int val;
    Pair(TreeNode node, int val)
    {
        this.node=node;
        this.val=val;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxi=0;
        Queue<Pair> nm=new LinkedList<>();
        nm.offer(new Pair(root,0));
        while(!nm.isEmpty())
        {
            int min=nm.peek().val;
            int size=nm.size();
            int first=0,last=0;
            for(int i=1;i<=size;i++)
            {
                Pair pq=nm.poll();
                if(i==1)
                {
                    first=pq.val;
                }
                else if(i==size)
                {
                    last=pq.val;
                }
                if(pq.node.left!=null)
                {
                    nm.offer(new Pair(pq.node.left, (pq.val-min)*2+1));
                }
                if(pq.node.right!=null)
                {
                    nm.offer(new Pair(pq.node.right, (pq.val-min)*2+2));
                }
            }
            maxi=Math.max(maxi, last-first+1);
        }
        return maxi;
    }
}