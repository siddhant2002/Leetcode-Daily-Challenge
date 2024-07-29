class Tree {
    // Function to return the ceil of given number in BST.
    
    static int ans;
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        ans = Integer.MAX_VALUE;
        
        task(root, key);
        
        if(ans == Integer.MAX_VALUE) return -1;
        
        return ans;
    }
    
    static void task(Node root, int key) {
        if(root == null) return;
        
        if(root.data == key) {
            ans = key;
            return;
        }
        
        if(root.data > key) {
            ans = Math.min(ans, root.data);
            task(root.left, key);
        }
        else {
            task(root.right, key);
        }
    }
}
