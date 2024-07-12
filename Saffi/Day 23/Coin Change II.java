class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        // int[][] dp = new int[n][amount + 1];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(coins.length - 1, coins, amount, dp);

        // int[][] dp = new int[n][amount + 1];
        int[] prev = new int[amount + 1];

        for(int amt = 0; amt <= amount; amt++) {
            if(amt % coins[0] == 0) {
                // dp[0][amt] = 1;
                prev[amt] = 1;
            }
        }

        for(int ind = 1; ind < n; ind++) {
            int curr[] = new int[amount + 1];
            for(int amt = 0; amt <= amount; amt++) {
                int pick = 0, notPick = 0;

                // notPick = dp[ind - 1][amt];
                notPick = prev[amt];

                if(coins[ind] <= amt) {
                    // pick = dp[ind][amt - coins[ind]];
                    pick = curr[amt - coins[ind]];
                }

                // dp[ind][amt] = pick + notPick;
                curr[amt] = pick + notPick;
            }

            prev = curr;
        }

        // return dp[n - 1][amount];
        return prev[amount];
    }

    static int task(int ind, int[] coins, int amount, int[][] dp) {

        if(ind == 0) {
            if(amount % coins[0] != 0) return 0;
            else return 1;
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];

        int pick = 0, notPick = 0;

        notPick = task(ind - 1, coins, amount, dp);

        if(coins[ind] <= amount) {
            pick = task(ind, coins, amount - coins[ind], dp);
        }

        return dp[ind][amount] = pick + notPick;
    }
}