class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // int dp[][] = new int[m][n];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(m - 1, n - 1, m, n, obstacleGrid, dp);

        // int dp[][] = new int[m][n];
        int prev[] = new int[n];

        // dp[0][0] = 1;
        prev[0] = 1;

        for(int x = 0; x < m; x++) {
            int[] curr = new int[n];
            if(x == 0) curr[0] = 1;
            for(int y = 0; y < n; y++) {
                if(x == 0 && y == 0) continue;

                if(obstacleGrid[x][y] == 1) continue;

                int ans = 0;

                if(x > 0) {
                    // ans += dp[x - 1][y];
                    ans += prev[y];
                }

                if(y > 0) {
                    // ans += dp[x][y - 1];
                    ans += curr[y - 1];
                }

                curr[y] = ans;
            }

            prev = curr;
        }

        // return dp[m - 1][n - 1];
        return prev[n - 1];
    }

    static int task(int x, int y, int m, int n, int[][] obstacleGrid, int[][] dp) {
        if(x == 0 && y == 0) {
            return 1;
        }

        if(obstacleGrid[x][y] == 1) return 0;

        if(dp[x][y] != -1) return dp[x][y];

        int ans = 0;

        if(x > 0) {
            ans += task(x - 1, y, m, n, obstacleGrid, dp);
        }

        if(y > 0) {
            ans += task(x, y - 1, m, n, obstacleGrid, dp);
        }

        return dp[x][y] = ans;
    } 
}