class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        
        boolean dfsVis[] = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, adj, V, vis, dfsVis)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int V, boolean[] vis, boolean dfsVis[]) {
        vis[node] = true;
        
        dfsVis[node] = true;
        
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                if(dfs(it, adj, V, vis, dfsVis)) {
                    return true;
                }
            }
            else if(dfsVis[it]) {
                return true;
            }
        }
        
        dfsVis[node] = false;
        
        return false;
    }
}