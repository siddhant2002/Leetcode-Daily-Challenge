class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        
        // int[][] dp = new int[n + 1][m + 1];
        int[] prev = new int[m + 1];
        
        int ans = 0;
        
        for(int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr = new int[m + 1];
            for(int ind2 = 1; ind2 <= m; ind2++) {
                
                if(S1.charAt(ind1 - 1) == S2.charAt(ind2 - 1)) {
                    // dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    curr[ind2] = 1 + prev[ind2 - 1];
                    
                    // ans = Math.max(ans, dp[ind1][ind2]);
                    ans = Math.max(ans, curr[ind2]);
                }
            }
            
            prev = curr;
        }
        
        return ans;
        
    }
}