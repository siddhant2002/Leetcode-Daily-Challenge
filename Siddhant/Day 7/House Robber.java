class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return task(nums,nums.length-1,dp);
    }
    private int task(int nums[], int ind, int dp[])
    {
        if(ind<0)
        {
            return 0;
        }
        if(dp[ind] != -1)
        {
            return dp[ind];
        }
        return dp[ind] = Math.max(nums[ind]+task(nums,ind-2,dp),task(nums,ind-1,dp));
    }
}