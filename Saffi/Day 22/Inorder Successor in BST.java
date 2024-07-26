class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
          //add code here.
          
            Node ans = null;
            
            while(true) {
                if(root == null) break;
                
                if(root != null && root.data <= x. data) {
                    root = root.right;
                }
                else if(root != null && root.data > x.data) {
                    ans = root;
                    
                    root = root.left;
                }
            }
            
            return ans;
         }
}