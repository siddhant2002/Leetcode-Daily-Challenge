class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i: nums)
        {
            sum+=i;
        }
        if(sum%2==1)
        {
            return false;
        }
        sum/=2;
        int n=nums.length;
        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0; i<n; i++)
        {
            dp[i][0]=true;
        }
        if(nums[0]<=sum)
        {
            dp[0][nums[0]]=true;
        }
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<=sum; j++)
            {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j >= nums[i])
                {
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][sum];
    }
}