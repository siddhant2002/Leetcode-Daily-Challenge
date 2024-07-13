class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // int[][] dp = new int[n][amount + 1];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // int ans = task(coins.length - 1, coins, amount, dp);

        // if(ans >= 1000000000) return -1;

        // return ans;

        // int[][] dp = new int[n][amount + 1];
        int[] prev = new int[amount + 1];

        for(int amt = 0; amt <= amount; amt++) {
            if(amt % coins[0] != 0) {
                // dp[0][amt] = 1000000000;
                prev[amt] = 1000000000;
            }
            else {
                // dp[0][amt] = amt / coins[0];
                prev[amt] = amt / coins[0];
            }
        }

        for(int ind = 1; ind < n; ind++) {
            int[] curr = new int[amount + 1];
            for(int amt = 0; amt <= amount; amt++) {
                int pick = 1000000000, notPick = 1000000000;

                // notPick = dp[ind - 1][amt];
                notPick = prev[amt];

                if(coins[ind] <= amt) {
                    // pick = 1 + dp[ind][amt - coins[ind]];
                    pick = 1 + curr[amt - coins[ind]];
                }

                // dp[ind][amt] = Math.min(pick, notPick);
                curr[amt] = Math.min(pick, notPick);
            }

            prev = curr;
        }

        // return dp[n - 1][amount] >= 1000000000 ? -1 : dp[n - 1][amount];
        return prev[amount] >= 1000000000 ? -1 : prev[amount];
    }

    static int task(int ind, int[] coins, int amount, int[][] dp) {

        if(ind == 0) {
            if(amount % coins[0] != 0) return 1000000000;
            else return amount / coins[0];
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];

        int pick = 1000000000, notPick = 1000000000;

        notPick = task(ind - 1, coins, amount, dp);

        if(coins[ind] <= amount) {
            pick = 1 + task(ind, coins, amount - coins[ind], dp);
        }

        return dp[ind][amount] = Math.min(pick, notPick);
    }
}