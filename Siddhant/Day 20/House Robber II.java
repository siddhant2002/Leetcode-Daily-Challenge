class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        return Math.max(task(nums,1,nums.length-1), task(nums,2,nums.length));
    }
    private int task(int nums[], int start, int end)
    {
        int dp[]=new int[end];
        dp[start-1]=nums[start-1];
        for(int i=start; i<end; i++)
        {
            int left=dp[i-1];
            int right=0;
            if(i > 1)
            {
                right = nums[i] + dp[i-2];
            }
            dp[i] = Math.max(left , right);
        }
        return dp[end-1];
    }
}