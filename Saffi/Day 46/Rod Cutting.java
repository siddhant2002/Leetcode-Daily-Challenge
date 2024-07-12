class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        // int[][] dp = new int[n][n + 1];
        
        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }
        
        // return task(n - 1, n, price, dp);
        
        // int[][] dp = new int[n][n + 1];
        int[] prev = new int[n + 1];
        
        for(int s = 0; s <= n; s++) {
            // dp[0][s] = s * price[0];
            prev[s] = s * price[0];
        }
        
        for(int ind = 1; ind < n; ind++) {
            int[] curr = new int[n + 1];
            for(int s = 0; s <= n; s++) {
                int pick = 0, notPick = 0;
        
                // notPick = dp[ind - 1][s];
                notPick = prev[s];
        
                if(s >= ind + 1) {
                    // pick = price[ind] + dp[ind][s - ind - 1];
                    pick = price[ind] + curr[s - ind - 1];
                }
        
                // dp[ind][s] = Math.max(pick, notPick);
                curr[s] = Math.max(pick, notPick);
            }
            
            prev = curr;
        }
        
        // return dp[n - 1][n];
        return prev[n];
    }
    
    static int task(int ind, int n, int[] price, int[][] dp) {
        
        if(ind == 0) {
            return n * price[0];
        }
        
        if(dp[ind][n] != -1) return dp[ind][n];
        
        int pick = 0, notPick = 0;
        
        notPick = task(ind - 1, n, price, dp);
        
        if(n >= ind + 1) {
            pick = price[ind] + task(ind, n - ind - 1, price, dp);
        }
        
        return dp[ind][n] = Math.max(pick, notPick);
    }
}