class Solution {
    public int climbStairs(int n) {

        // MEMOIZATION

        // int[] dp = new int[n + 1];

        // Arrays.fill(dp, -1);

        // dp[0] = 1;
        // dp[1] = 1;

        // return task(n, dp);

        // TABULATION

        // int dp[] = new int[n + 1];

        // dp[0] = 1;
        // dp[1] = 1;

        // for(int i = 2; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // return dp[n];

        // SPACE OPTIMIZATION

        int prev1 = 1, prev = 1;

        for(int i = 2; i <= n; i++) {
            int curr = prev1 + prev;

            prev1 = prev;
            prev = curr;
        }

        return prev;
    }

    static int task(int n, int[] dp) {
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = task(n - 1, dp) + task(n - 2, dp);
    }
}