class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        Stack<Node> stk = new Stack<>();
        
        Map<Node, Node> map = new HashMap<>();
        
        stk.push(root);
        
        Node targetNode = null;
        
        while(!stk.isEmpty()) {
            Node node = stk.pop();
            
            if(node.data == target) {
                targetNode = node;
            }
            
            if(node.left != null) {
                stk.push(node.left);

                map.put(node.left, node);
            }
            if(node.right != null) {
                stk.push(node.right);

                map.put(node.right, node);
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        q.offer(targetNode);
        
        int ans = 0;
        
        Set<Integer> vis = new HashSet<>();
        

        while(!q.isEmpty()) {
            int size = q.size();
            
            boolean flag = false;
            
            while(size-- > 0) {
                Node node = q.poll();
            
                vis.add(node.data);

                if(node.left != null && !vis.contains(node.left.data)) {
                    q.offer(node.left);
                    flag = true;
                }
                if(node.right != null && !vis.contains(node.right.data)) {
                    q.offer(node.right);
                    flag = true;
                }
                
                if(map.containsKey(node) && !vis.contains(map.get(node).data)) {
                    q.offer(map.get(node));
                    flag = true;
                }
            }
            
            if(flag) ans++;
            
        }
        
        return ans;

        
    }
}