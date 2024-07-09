public class Binary Search Tree Iterator {
    
}
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
    List<Integer> list;
    static int ptr;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        ptr = -1;

        Stack<TreeNode> stk = new Stack<>();

        TreeNode node = root;

        while(true) {
            if(node != null) {
                stk.push(node);
                node = node.left;
            }
            else {
                if(stk.isEmpty()) break;

                node = stk.pop();

                list.add(node.val);

                node = node.right;
            }
        }
    }
    
    public int next() {
        return list.get(++ptr);
    }
    
    public boolean hasNext() {
        return ptr < list.size() - 1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */