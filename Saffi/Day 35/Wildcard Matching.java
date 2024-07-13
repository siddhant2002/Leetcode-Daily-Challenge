class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // int dp[][] = new int[m][n];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(m - 1, n - 1, s, p, dp) == 1;

        // int dp[][] = new int[m + 1][n + 1];
        int prev[] = new int[n + 1];

        // dp[0][0] = 1;
        prev[0] = 1;

        for(int ind2 = 1; ind2 <= n; ind2++) {
            if(isAllStars(ind2, p)) {
                // dp[0][ind2] = 1;
                prev[ind2] = 1;
            }
        }

        for(int ind1 = 1; ind1 <= m; ind1++) {
            int curr[] = new int[n + 1];
            for(int ind2 = 1; ind2 <= n; ind2++) {
                if(s.charAt(ind1 - 1) == p.charAt(ind2 - 1) || p.charAt(ind2 - 1) == '?') {
                    // dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                    curr[ind2] = prev[ind2 - 1];
                    continue;
                }

                if(p.charAt(ind2 - 1) == '*') {
                    // dp[ind1][ind2] = dp[ind1 - 1][ind2] == 1 || dp[ind1][ind2 - 1] == 1 ? 1 : 0;
                    curr[ind2] = prev[ind2] == 1 || curr[ind2 - 1] == 1 ? 1 : 0;
                    continue;
                }

                // dp[ind1][ind2] = 0;
                curr[ind2] = 0;
            }

            prev = curr;
        }

        // return dp[m][n] == 1;
        return prev[n] == 1;
    }

    static int task(int ind1, int ind2, String s, String p, int[][] dp) {

        if(ind1 < 0 && ind2 < 0) return 1;

        if(ind2 < 0) return 0;

        if(ind1 < 0) {
            return isAllStars(ind2, p) ? 1 : 0;
        }

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s.charAt(ind1) == p.charAt(ind2) || p.charAt(ind2) == '?') {
            return dp[ind1][ind2] = task(ind1 - 1, ind2 - 1, s, p, dp);
        }

        if(p.charAt(ind2) == '*') {
            return dp[ind1][ind2] = task(ind1 - 1, ind2, s, p, dp) == 1 || task(ind1, ind2 - 1, s, p, dp) == 1 ? 1 : 0;
        }

        return dp[ind1][ind2] = 0;
    }

    static boolean isAllStars(int ind, String p) {

        // for memoization
        // for(int i = 0; i <= ind; i++) {
        //     if(p.charAt(i) != '*') return false;
        // }

        // for tabulation
        for(int i = 1; i <= ind; i++) {
            if(p.charAt(i - 1) != '*') return false;
        }

        return true;
    }
}