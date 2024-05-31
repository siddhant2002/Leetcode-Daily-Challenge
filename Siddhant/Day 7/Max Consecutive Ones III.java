class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxi=0,count=0;
        int i=0,j=0;
        for(;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count++;
            }
            if(count>k)
            {
                maxi=Math.max(maxi,i-j);
                while(count>k)
                {
                    if(nums[j]==0)
                    {
                        count--;
                    }
                    j++;
                }
            }
        }
        return Math.max(maxi,i-j);
    }
}