class Solution {
    public int rob(int[] nums) {
        // int dp[] = new int[nums.length];

        // Arrays.fill(dp, -1);

        // return task(nums, nums.length - 1, dp);

        int n = nums.length;

        // int[] dp = new int[n];
        // dp[0] = nums[0];

        int prev1 = 0, prev = nums[0];

        for(int ind = 1; ind < n; ind++) {
            int pick = nums[ind], notPick = 0;

            // notPick = dp[ind - 1];
            notPick = prev;

            if(ind > 1) {
                // pick += dp[ind - 2];
                pick += prev1;
            }

            // dp[ind] = Math.max(pick, notPick);
            int curr = Math.max(pick, notPick);

            prev1 = prev;
            prev = curr;
        }

        // return dp[n - 1];
        return prev;
    }

    static int task(int[] nums, int ind, int[] dp) {
        if(ind < 0) return 0;

        if(ind == 0) {
            return nums[0];
        }

        if(dp[ind] != -1) return dp[ind];

        int pick = 0, notPick = 0;

        notPick = task(nums, ind - 1, dp);

        pick = nums[ind] + task(nums, ind - 2, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}