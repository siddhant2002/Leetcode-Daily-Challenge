class Solution {
    
    static int ans;
    public static int floor(Node root, int x) {
        // Code here
        
        ans = Integer.MIN_VALUE;
        
        task(root, x);
        
        if(ans == Integer.MIN_VALUE) return -1;
        
        return ans;
    }
    
    static void task(Node root, int x) {
        if(root == null) return;
        
        if(root.data == x) ans = x;
        
        if(root.data < x) {
            ans = Math.max(ans, root.data);
            
            task(root.right, x);
            return;
        }
        else {
            task(root.left, x);
        }
    }
}