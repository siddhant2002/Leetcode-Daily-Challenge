class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int count = 0;

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                count++;

                dfs(i, isConnected, vis, n);
            }
        }

        return count;
    }

    static void dfs(int node, int[][] isConnected, boolean[] vis, int n) {
        
        vis[node] = true;

        for(int i = 0; i < n; i++) {
            if(isConnected[node][i] == 1 && !vis[i]) {
                dfs(i, isConnected, vis, n);
            }
        }
    }
}