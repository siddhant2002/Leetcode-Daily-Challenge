class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis[] = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, -1, vis, adj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    static boolean dfs(int node, int par, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                if(dfs(it, node, vis, adj)) {
                    return true;
                }
            }
            else if(it != par) {
                return true;
            }
        }
        
        return false;
    }
}