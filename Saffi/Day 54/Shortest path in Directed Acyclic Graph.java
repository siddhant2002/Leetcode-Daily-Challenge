class Pair {
    int node, distance;
    
    Pair(int n, int d) {
        node = n;
        distance = d;
    }
}

class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		List<List<Pair>> adj = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int i = 0; i < M; i++) {
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		int dist[] = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		dist[0] = 0;
		
		while(!q.isEmpty()) {
		    int node = q.poll();
		    
		    for(Pair it : adj.get(node)) {
		        if(it.distance + dist[node] < dist[it.node]) {
		            dist[it.node] = it.distance + dist[node];
		            q.offer(it.node);
		        }
		    }
		}
		
		for(int i = 0; i < N; i++) {
		    if(dist[i] == Integer.MAX_VALUE) {
		        dist[i] = -1;
		    }
		}
		
		return dist;
	}
}