class Solution {
    public boolean canPartition(int[] nums) {
        int target=0;
        for(int i:nums)
        {
            target+=i;
        }
        if(target%2==1)
        {
            return false;
        }
        boolean dp[]=new boolean[target+1];
        dp[0]=true;
        if(target<=dp.length)
        {
            dp[target]=true;
        }
        for(int ind=1;ind<nums.length;ind++)
        {
            boolean cur[]=new boolean[target+1];
            cur[0]=true;
            for(int sum=1;sum<=target;sum++)
            {
                boolean nottake=dp[sum];
                boolean take=false;
                if(sum>=nums[ind])
                {
                    take=dp[sum-nums[ind]];
                }
                cur[sum]=take||nottake;
            }
            dp=cur;
        }
        return dp[target/2];
    }
}