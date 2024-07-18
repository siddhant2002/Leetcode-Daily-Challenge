class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();

        int v = graph.length;

        for(int i = 0; i < v; i++) {
            adjRev.add(new ArrayList<>());
        }

        for(int i = 0; i < v; i++) {
            for(int it : graph[i]) {
                adjRev.get(it).add(i);
            }
        }

        int indegree[] = new int[v];
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < v; i++) {
            for(int it : adjRev.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < v; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int ind = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int it : adjRev.get(node)) {
                indegree[it]--;
                
                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        Collections.sort(ans);

        return ans;
    }
}