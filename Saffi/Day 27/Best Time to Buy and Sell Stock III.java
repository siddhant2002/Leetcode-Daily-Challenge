class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        // int[][][] dp = new int[n][2][3];

        // for(int[][] temp : dp) {
        //     for(int[] row : temp) {
        //         Arrays.fill(row, -1);
        //     }
        // }

        // return task(n - 1, prices, 0, 2, dp);

        // int[][][] dp = new int[n][2][3];
        int[][] prev = new int[2][3];

        // dp[0][1][1] = dp[0][1][2] = - prices[0];
        prev[1][1] = prev[1][2] = - prices[0];

        for(int ind = 1; ind < n; ind++) {
            int[][] curr = new int[2][3];
            for(int flag = 0; flag < 2; flag++) {
                for(int count = 1; count <= 2; count++) {
                    int pick = 0, notPick = 0;

                    if(flag == 1) {
                        // pick = - prices[ind] + dp[ind - 1][0][count - 1];
                        pick = - prices[ind] + prev[0][count - 1];

                        // notPick = dp[ind - 1][1][count];
                        notPick = prev[1][count];
                    }
                    else {
                        // pick = prices[ind] + dp[ind - 1][1][count];
                        pick = prices[ind] + prev[1][count];

                        // notPick = dp[ind - 1][0][count];
                        notPick = prev[0][count];
                    }

                    // dp[ind][flag][count] = Math.max(pick, notPick);
                    curr[flag][count] = Math.max(pick, notPick);
                }
            }

            prev = curr;
        }

        // return dp[n - 1][0][2];
        return prev[0][2];
    }

    static int task(int ind, int[] prices, int flag, int count, int[][][] dp) {

        if(count == 0) return 0;

        if(ind == 0) {
            if(flag == 1) {
                return - prices[0];
            }
            
            return 0;
        }

        if(dp[ind][flag][count] != -1) return dp[ind][flag][count];

        int pick = 0, notPick = 0;

        if(flag == 1) {
            pick = - prices[ind] + task(ind - 1, prices, 0, count - 1, dp);

            notPick = task(ind - 1, prices, 1, count, dp);
        }
        else {
            pick = prices[ind] + task(ind - 1, prices, 1, count, dp);

            notPick = task(ind - 1, prices, 0, count, dp);
        }

        return dp[ind][flag][count] = Math.max(pick, notPick);
    }
}