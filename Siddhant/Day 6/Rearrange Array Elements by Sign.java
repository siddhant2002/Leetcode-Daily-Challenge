class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len=nums.length;
        int ans[]=new int[len];
        int pointer1=0,pointer2=1;
        for(int i=0;i<len;i++)
        {
            if(nums[i]>0)
            {
                ans[pointer1]=nums[i];
                pointer1+=2;
            }
            else
            {
                ans[pointer2]=nums[i];
                pointer2+=2;
            }
        }
        return ans;
    }
}