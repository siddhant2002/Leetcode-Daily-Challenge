class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // int dp[][] = new int[m][n];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(m - 1, n - 1, m, n, grid, dp);

        // int dp[][] = new int[m][n];
        int prev[] = new int[n];

        // dp[0][0] = grid[0][0];
        prev[0] = grid[0][0];

        for(int x=  0; x < m; x++) {
            int[] curr = new int[n];
            if(x == 0) curr[0] = grid[0][0];
            for(int y = 0; y < n; y++) {
                if(x == 0 && y == 0) continue;

                int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;

                if(x > 0) {
                    // top = dp[x - 1][y];
                    top = prev[y];
                }
        
                if(y > 0) {
                    // left = dp[x][y - 1];
                    left = curr[y - 1];
                }

                // dp[x][y] = grid[x][y] + Math.min(top, left);
                curr[y] = grid[x][y] + Math.min(top, left);
            }

            prev = curr;
        }

        // return dp[m - 1][n - 1];
        return prev[n - 1];
    }

    static int task(int x, int y, int m, int n, int[][] grid, int[][] dp) {
        if(x == 0 && y == 0) {
            return grid[x][y];
        }

        if(dp[x][y] != -1) return dp[x][y];

        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;

        if(x > 0) {
            top = task(x - 1, y, m, n, grid, dp);
        }
        
        if(y > 0) {
            left = task(x, y - 1, m, n, grid, dp);
        }

        return dp[x][y] = grid[x][y] + Math.min(top, left);
    }
}