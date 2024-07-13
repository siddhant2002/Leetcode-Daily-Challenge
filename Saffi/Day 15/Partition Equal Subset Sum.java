class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, N = nums.length;

        for(int i : nums) {
            sum += i;
        }

        if((sum & 1) != 0) return false;

        sum = sum / 2;

        // int dp[][] = new int[N][sum + 1];
        
        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(N - 1, N, nums, sum, dp) == 1;

        // int dp[][] = new int[N][sum + 1];
        int prev[] = new int[sum + 1];
        
        // for(int ind = 0; ind < N; ind++) {
        //     dp[ind][0] = 1;
        // }
        prev[0] = 1;
        
        for(int s = 0; s <= sum; s++) {
            if(s == nums[0]) {
                // dp[0][s] = 1;
                prev[s] = 1;
            }
        }
        
        for(int ind = 1; ind < N; ind++) {
            int curr[] = new int[sum + 1];
            for(int s = 0; s <= sum; s++) {
                int pick = 0, notPick = 0;
        
                // notPick = dp[ind - 1][s];
                notPick = prev[s];
        
                if(s >= nums[ind]) {
                    // pick = dp[ind - 1][s - arr[ind]];
                    pick = prev[s - nums[ind]];
                }
        
                // dp[ind][s] = notPick | pick;
                curr[s] = notPick | pick;
            }
            
            prev = curr;
        }
        
        // return dp[N - 1][sum] == 1;
        return prev[sum] == 1;
    }

    static int task(int ind, int n, int[] arr, int sum, int[][] dp) {
        if(sum == 0) return 1;
        
        if(ind == 0) {
            if(sum == arr[0]) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        if(dp[ind][sum] != -1) return dp[ind][sum];
        
        int pick = 0, notPick = 0;
        
        notPick = task(ind - 1, n, arr, sum, dp);
        
        if(sum >= arr[ind]) {
            pick = task(ind - 1, n, arr, sum - arr[ind], dp);
        }
        
        return dp[ind][sum] = notPick | pick;
    }
}