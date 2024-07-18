class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // int dp[][] = new int[n][n + 1];

        // for(int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // return task(0, -1, nums, dp);

        // int dp[][] = new int[n + 1][n + 1];
        int next[] = new int[n + 1];

        for(int ind = n - 1; ind >= 0; ind--) {
            int curr[] = new int[n + 1];
            for(int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {
                int pick = 0, notPick = 0;

                if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
                    // pick = 1 + dp[ind + 1][ind + 1];
                    pick = 1 + next[ind + 1];
                }

                // notPick = dp[ind + 1][prev_ind + 1];
                notPick = next[prev_ind + 1];

                // dp[ind][prev_ind + 1] = Math.max(pick, notPick);
                curr[prev_ind + 1] = Math.max(pick, notPick);
            }

            next = curr;
        }

        // return dp[0][- 1 + 1];
        return next[- 1 + 1];
    }

    static int task(int ind, int prev_ind, int[] nums, int[][] dp) {
        if(ind == nums.length) {
            return 0;
        }

        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];

        int pick = 0, notPick = 0;

        if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            pick = 1 + task(ind + 1, ind, nums, dp);
        }

        notPick = task(ind + 1, prev_ind, nums, dp);

        return dp[ind][prev_ind + 1] = Math.max(pick, notPick);
    }
}