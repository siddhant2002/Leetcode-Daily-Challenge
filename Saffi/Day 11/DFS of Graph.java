class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean vis[] = new boolean[V];
        
        Arrays.fill(vis, false);
        
        task(0, adj, vis, ans);
        
        return ans;
    }
    
    static void task(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        ans.add(node);
        
        vis[node] = true;
        
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                task(it, adj, vis, ans);
            }
        }
    }
}