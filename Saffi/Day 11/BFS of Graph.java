class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean vis[] = new boolean[V];
        
        Arrays.fill(vis, false);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            ans.add(node);
            
            for(int it : adj.get(node)) {
                if(!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }
        
        return ans;
    }
}