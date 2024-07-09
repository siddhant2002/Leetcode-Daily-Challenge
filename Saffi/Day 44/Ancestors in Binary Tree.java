class Solution {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root.data == target) return ans;
        
        HashMap<Node, Node> map = new HashMap<>();
        
        map.put(root, null);
        
        Stack<Node> stk = new Stack<>();
        
        stk.push(root);
        
        Node node = null;
        
        while(!stk.isEmpty()) {
            node = stk.pop();
            
            if(node.data == target) break;
            
            if(node.right != null) {
                map.put(node.right, node);
                stk.push(node.right);
            }
            
            if(node.left != null) {
                map.put(node.left, node);
                stk.push(node.left);
            }
        }
        
        while(map.get(node) != null) {
            ans.add(map.get(node).data);
            
            node = map.get(node);
        }
        
        return ans;
    }
}