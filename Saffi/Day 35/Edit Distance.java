class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // int[][] dp = new int[m][n];
        // for (int row[] : dp) {
        //     Arrays.fill(row, -1);
        // }
            
        // return task(m - 1, n - 1, word1, word2, dp);

        // int[][] dp = new int[m + 1][n + 1];
        int[] prev = new int[n + 1];

        // for (int ind1 = 0; ind1 <= m; ind1++) {
        //     dp[ind1][0] = ind1;
        // }

        for (int ind2 = 0; ind2 <= n; ind2++) {
            // dp[0][ind2] = ind2;
            prev[ind2] = ind2;
        }

        for (int ind1 = 1; ind1 <= m; ind1++) {
            int curr[] = new int[n + 1];
            curr[0] = ind1;
            for (int ind2 = 1; ind2 <= n; ind2++) {
                if (word1.charAt(ind1 - 1) == word2.charAt(ind2 - 1)) {
                    // dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                    curr[ind2] = prev[ind2 - 1];
                } else {
                    // dp[ind1][ind2] = 1 + Math.min(dp[ind1 - 1][ind2 - 1], Math.min(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]));
                    curr[ind2] = 1 + Math.min(prev[ind2 - 1], Math.min(prev[ind2], curr[ind2 - 1]));
                }
            }

            prev = curr;
        }

        // return dp[m][n];
        return prev[n];
    }

    static int task(int ind1, int ind2, String word1, String word2, int[][] dp) {

        if(ind1 < 0) return ind2 + 1;

        if(ind2 < 0) return ind1 + 1;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        if(word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = task(ind1 - 1, ind2 - 1, word1, word2, dp);
        }

        return dp[ind1][ind2] = 1 + Math.min(task(ind1 - 1, ind2, word1, word2, dp), Math.min(task(ind1, ind2 - 1, word1, word2, dp), task(ind1 - 1, ind2 - 1, word1, word2, dp)));
    }
}