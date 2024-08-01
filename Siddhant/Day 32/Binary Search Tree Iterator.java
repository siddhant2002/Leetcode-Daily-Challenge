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
class BSTIterator {

    Stack<TreeNode> nm=new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root!=null)
        {
            nm.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode node=nm.pop();
        int val=node.val;
        node=node.right;
        while(node!=null)
        {
            nm.push(node);
            node=node.left;
        }
        return val;
    }
    
    public boolean hasNext() {
        return !nm.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */