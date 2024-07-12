class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        // int ans = 0;
        
        // int dp[][] = new int[N][3];
        
        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }
        
        // for(int i = 0; i < 3; i++) {
        //     ans = Math.max(ans, task(points, N - 1, i, dp));
        // }
        
        // return ans;
        
        // int dp[][] = new int[N][3];
        int[] prev = new int[3];
        
        for(int i = 0; i < 3; i++) {
            // dp[0][i] = points[0][i];
            prev[i] = points[0][i];
        }
        
        
        for(int ind = 1; ind < N; ind++) {
            int curr[] = new int[3];
            for(int act = 0; act < 3; act++) {
                int ans = 0;
                for(int i = 0; i < 3; i++) {
                    if(i != act) {
                        // ans = Math.max(ans, points[ind][act] + dp[ind - 1][i]);
                        ans = Math.max(ans, points[ind][act] + prev[i]);
                    }
                }
                
                // dp[ind][act] = ans;
                curr[act] = ans;
            }
            prev = curr;
        }
        
        int res = 0;
        
        for(int i = 0; i < 3; i++) {
            // res = Math.max(res, dp[N - 1][i]);
            res = Math.max(res, prev[i]);
        }
        
        return res;
        
    }
    
    static int task(int[][] points, int ind, int act, int[][] dp) {
        if(ind == 0) {
            return points[0][act];
        }
        
        if(dp[ind][act] != -1) return dp[ind][act];
        
        int ans = 0;
        
        for(int i = 0; i < 3; i++) {
            if(i != act) {
                ans = Math.max(ans, points[ind][act] + task(points, ind - 1, i, dp));
            }
        }
        
        return dp[ind][act] = ans;
    }
}