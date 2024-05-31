class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int val1=task1(nums,nums.length-2,dp);
        Arrays.fill(dp,-1);
        int val2=task2(nums,nums.length-1,dp);
        return Math.max(val1,val2);
    }
    private int task1(int nums[], int ind, int dp[])
    {
        if(ind<0)
        {
            return 0;
        }
        if(dp[ind] != -1)
        {
            return dp[ind];
        }
        return dp[ind] = Math.max(nums[ind]+task1(nums,ind-2,dp),task1(nums,ind-1,dp));
    }
    private int task2(int nums[], int ind, int dp[])
    {
        if(ind<1)
        {
            return 0;
        }
        if(dp[ind] != -1)
        {
            return dp[ind];
        }
        return dp[ind] = Math.max(nums[ind]+task2(nums,ind-2,dp),task2(nums,ind-1,dp));
    }
}