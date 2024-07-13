class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        // int[][] dp = new int[m][m];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // int ans = Integer.MAX_VALUE;

        // for(int i = 0; i < m; i++) {
        //     ans = Math.min(ans, task(m - 1, i, m, triangle, dp));
        // }

        // return ans;

        // int[][] dp = new int[m][m];
        int[] prev = new int[m];

        prev[0] = triangle.get(0).get(0);

        for(int x = 1; x < m; x++) {
            int curr[] = new int[m];
            for(int y = 0; y <= x; y++) {
                int ans = Integer.MAX_VALUE;
                if(y > 0) {
                    // ans = Math.min(ans, dp[x - 1][y - 1]);
                    ans = Math.min(ans, prev[y - 1]);
                }

                if(y < x) {
                    // ans = Math.min(ans, dp[x - 1][y]);
                    ans = Math.min(ans, prev[y]);
                }

                // dp[x][y] = triangle.get(x).get(y) + ans;
                curr[y] = triangle.get(x).get(y) + ans;
            }

            prev = curr;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++) {
            // ans = Math.min(ans, dp[m - 1][i]);
            ans = Math.min(ans, prev[i]);
        }

        return ans;
    }

    static int task(int x, int y, int m, List<List<Integer>> triangle, int[][] dp) {
        if(x == 0) {
            return triangle.get(0).get(0);
        }

        if(dp[x][y] != -1) return dp[x][y];

        int ans = Integer.MAX_VALUE;

        if(y > 0) {
            ans = Math.min(ans, task(x - 1, y - 1, m, triangle, dp));
        }

        if(y < x) {
            ans = Math.min(ans, task(x - 1, y, m, triangle, dp));
        }

        return dp[x][y] = triangle.get(x).get(y) + ans;
    }
}