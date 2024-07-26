class Tuple {
    int min, max, size;
    
    Tuple(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        
        return task(root).size;
        
    }
    
    static Tuple task(Node node) {
        if(node == null) return new Tuple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        
        Tuple leftRes = task(node.left);
        Tuple rightRes = task(node.right);
        
        if(node.data > leftRes.max && node.data < rightRes.min) {
            return new Tuple(Math.min(node.data, leftRes.min), Math.max(node.data, rightRes.max), 1 + leftRes.size + rightRes.size);
        }
        
        return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftRes.size, rightRes.size));
        
    }
    
}