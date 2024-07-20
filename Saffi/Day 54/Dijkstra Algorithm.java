class Pair {
    int distance, node;
    
    Pair(int d, int n) {
        distance = d;
        node = n;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        int dist[] = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        pq.offer(new Pair(0, S));
        
        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            
            pq.poll();
            
            for(ArrayList<Integer> it : adj.get(node)) {
                if(dist[node] + it.get(1) < dist[it.get(0)]) {
                    dist[it.get(0)] = dist[node] + it.get(1);
                    
                    pq.offer(new Pair(dist[it.get(0)], it.get(0)));
                }
            }
        }
        
        return dist;
    }
}
