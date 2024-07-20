class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int dist[] = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(src);
        dist[src] = 0;
        
        while(!q.isEmpty()) {
            int node = q.peek();
            
            q.poll();
            
            for(int it : adj.get(node)) {
                if(1 + dist[node] < dist[it]) {
                    dist[it] = 1 + dist[node];
                    
                    q.offer(it);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}