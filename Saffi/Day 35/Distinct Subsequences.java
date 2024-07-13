class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        // int[][] dp = new int[m][n];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }
        // return task(m - 1, n - 1, s, t, dp);

        // int[][] dp = new int[m + 1][n + 1]; 
        int[] prev = new int[n + 1]; 

        // for(int ind1 = 0; ind1 < m; ind1++) {
        //     dp[ind1][0] = 1;
        // }
        prev[0] = 1;

        for(int ind1 = 1; ind1 <= m; ind1++) {
            int curr[] = new int[n + 1];
            curr[0] = 1;

            for(int ind2 = 1; ind2 <= n; ind2++) {
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1)) {
                    // dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1] + dp[ind1 - 1][ind2];
                    curr[ind2] = prev[ind2 - 1] + prev[ind2];
                }
                else {
                    curr[ind2] = prev[ind2];
                }
            }

            prev = curr;
        }

        // return dp[m][n];
        return prev[n];
    }

    static int task(int ind1, int ind2, String s, String t, int[][] dp) {
        if(ind2 < 0) {
            return 1;
        }

        if(ind1 < 0) {
            return 0;
        }

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2]; 

        if(s.charAt(ind1) == t.charAt(ind2)) {
            return dp[ind1][ind2] = task(ind1 - 1, ind2 - 1, s, t, dp) + task(ind1 - 1, ind2, s, t, dp);
        }

        return dp[ind1][ind2] = task(ind1 - 1, ind2, s, t, dp);
    }
}