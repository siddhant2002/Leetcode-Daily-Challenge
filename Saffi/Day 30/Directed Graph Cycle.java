class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int indegree[] = new int[V];
        
        for(int i = 0; i < V; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for(int it : adj.get(node)) {
                indegree[it]--;
                
                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        return count != V;
    }
}