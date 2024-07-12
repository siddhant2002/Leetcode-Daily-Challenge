class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        
        // int dp[][] = new int[N][W + 1];
        
        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }
        
        // return task(N - 1, W, val, wt, dp);
        
        // int dp[][] = new int[N][W + 1];
        int prev[] = new int[W + 1];
        
        for(int w = 0; w <= W; w++) {
            // dp[0][w] = val[0] * (w / wt[0]);
            prev[w] = val[0] * (w / wt[0]);
        }
        
        for(int ind = 1; ind < N; ind++) {
            int curr[] = new int[W + 1];
            for(int w = 0; w <= W; w++) {
                int pick = 0, notPick = 0;
        
                // notPick = dp[ind - 1][w];
                notPick = prev[w];
        
                if(w >= wt[ind]) {
                    // pick = val[ind] + dp[ind][w - wt[ind]];
                    pick = val[ind] + curr[w - wt[ind]];
                }
        
                // dp[ind][w] = Math.max(pick, notPick);
                curr[w] = Math.max(pick, notPick);
            }
            
            prev = curr;
        }
        
        // return dp[N - 1][W];
        return prev[W];
    }
    
    static int task(int ind, int w, int[] val, int[] wt, int[][] dp) {
        
        if(ind == 0) {
            return val[0] * (w / wt[0]);
        }
        
        if(dp[ind][w] != -1) return dp[ind][w];
        
        int pick = 0, notPick = 0;
        
        notPick = task(ind - 1, w, val, wt, dp);
        
        if(w >= wt[ind]) {
            pick = val[ind] + task(ind, w - wt[ind], val, wt, dp);
        }
        
        return dp[ind][w] = Math.max(pick, notPick);
    }
}