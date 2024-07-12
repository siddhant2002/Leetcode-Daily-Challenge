class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int i : nums) {
            sum += i;
        }

        sum -= target;

        if(sum < 0 || (sum & 1) != 0) return 0;

        sum /= 2;

        int n = nums.length;

        // int dp[][] = new int[n][sum + 1];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(n - 1, nums, sum, dp);

        // int dp[][] = new int[n][sum + 1];
        int prev[] = new int[sum + 1];

        if(nums[0] == 0) {
            // dp[0][0] = 2;
            prev[0] = 2;
        }
        else {
            // dp[0][0] = 1;
            prev[0] = 1;
        }

        if(nums[0] != 0 && sum >= nums[0]) {
            // dp[0][nums[0]] = 1;
            prev[nums[0]] = 1;
        }

        for(int ind = 1; ind < n; ind++) {
            int curr[] = new int[sum + 1];
            for(int s = 0; s <= sum; s++) {
                int pick = 0, notPick = 0;

                // notPick = dp[ind - 1][s];
                notPick = prev[s];

                if(s >= nums[ind]) {
                    // pick = dp[ind - 1][s - nums[ind]];
                    pick = prev[s - nums[ind]];
                }

                // dp[ind][s] = pick + notPick;
                curr[s] = pick + notPick;
            }

            prev = curr;
        }

        // return dp[n - 1][sum];
        return prev[sum];
    }

    static int task(int ind, int[] nums, int sum, int[][] dp) {
        if(ind == 0) {
            if(sum == 0 && nums[ind] == 0) return 2;
            else if(sum == 0 || sum == nums[ind]) return 1;

            return 0;
        }

        if(dp[ind][sum] != -1) return dp[ind][sum];

        int pick = 0, notPick = 0;

        notPick = task(ind - 1, nums, sum, dp);

        if(sum >= nums[ind]) {
            pick = task(ind - 1, nums, sum - nums[ind], dp);
        }

        return dp[ind][sum] = pick + notPick;
    }
}