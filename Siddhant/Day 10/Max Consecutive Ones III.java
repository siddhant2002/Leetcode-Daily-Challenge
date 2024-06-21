class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxi=0,count=0;
        for(int i=0,j=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                while(k==0)
                {
                    maxi=Math.max(maxi,count);
                    if(nums[j]==0)
                    {
                        k++;
                    }
                    j++;
                    count--;
                }
                k--;
                count++;
            }
            else
            {
                count++;
            }
        }
        return Math.max(maxi,count);
    }
}