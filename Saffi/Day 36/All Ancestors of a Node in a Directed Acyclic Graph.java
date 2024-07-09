class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            boolean vis[] = new boolean[n];

            List<Integer> temp = new ArrayList<>();

            dfs(i, i, vis, temp, adj);

            Collections.sort(temp);

            ans.add(temp);
        }

        return ans;
    }

    static void dfs(int node, int key, boolean[] vis, List<Integer> temp, List<List<Integer>> adj) {
        vis[node] = true;

        if(node != key) temp.add(node);

        for(int it : adj.get(node)) {
            if(!vis[it]) {
                dfs(it, key, vis, temp, adj);
            }
        }
    }
}