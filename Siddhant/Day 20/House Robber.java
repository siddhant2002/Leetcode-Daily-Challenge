class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        int dp[]=new int[len];
        Arrays.fill(dp,-1);
        return task(nums,len-1,dp);
    }
    private int task(int nums[], int i, int dp[])
    {
        if(i < 0)
        {
            return 0;
        }
        if(i == 0)
        {
            return nums[0];
        }
        if(dp[i] != -1)
        {
            return dp[i];
        }
        int left=task(nums,i-1,dp);
        int right=0;
        if(i > 0)
        {
            right = nums[i] + task(nums,i-2,dp);
        }
        return dp[i] = Math.max(left , right);
    }
}