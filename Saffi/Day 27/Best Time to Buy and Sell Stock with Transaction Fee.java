class Solution {
    public int maxProfit(int[] prices, int fee) {
        // int[][] dp = new int[prices.length][2];

        // for(int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return task(prices.length - 1, prices, 0, dp, fee);

        // int[][] dp = new int[prices.length][2];
        int[] prev = new int[2];

        // dp[0][1] = - prices[0] - fee;
        prev[1] = - prices[0] - fee;

        for(int ind = 1; ind < prices.length; ind++) {
            int[] curr = new int[2];
            for(int flag = 0; flag < 2; flag++) {
                int pick = 0, notPick = 0;

                if(flag == 1) {
                    // pick = - prices[ind] - fee + dp[ind - 1][0];
                    pick = - prices[ind] - fee + prev[0];

                    // notPick = dp[ind - 1][1];
                    notPick = prev[1];
                }
                else {
                    // pick = prices[ind] + dp[ind - 1][1];
                    pick = prices[ind] + prev[1];

                    // notPick = dp[ind - 1][0];
                    notPick = prev[0];
                }

                // dp[ind][flag] = Math.max(pick, notPick);
                curr[flag] = Math.max(pick, notPick);
            }

            prev = curr;
        }

        // return dp[prices.length - 1][0];
        return prev[0];
    }

    static int task(int ind, int[] prices, int flag, int[][] dp, int fee) {

        if(ind == 0) {
            if(flag == 1) {
                return - prices[0] - fee;
            }
            
            return 0;
        }

        if(dp[ind][flag] != -1) return dp[ind][flag];

        int pick = 0, notPick = 0;

        if(flag == 1) {
            pick = - prices[ind] - fee + task(ind - 1, prices, 0, dp, fee);

            notPick = task(ind - 1, prices, 1, dp, fee);
        }
        else {
            pick = prices[ind] + task(ind - 1, prices, 1, dp, fee);

            notPick = task(ind - 1, prices, 0, dp, fee);
        }

        return dp[ind][flag] = Math.max(pick, notPick);
    }
}