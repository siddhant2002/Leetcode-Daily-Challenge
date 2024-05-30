class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,len=nums.length,maxi=Integer.MIN_VALUE;
        for(int i=0;i<len;i++)
        {
            sum=sum+nums[i];
            maxi=Math.max(maxi,sum);
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxi;
    }
}