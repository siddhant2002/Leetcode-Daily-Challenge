class Solution {
    public int findMin(int[] nums) {
        int mini=Integer.MAX_VALUE;
        int i=0,j=nums.length-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(nums[i]<=nums[mid])
            {
                mini=Math.min(mini,nums[i]);
                i=mid+1;
            }
            else
            {
                mini=Math.min(mini,nums[mid]);
                j=mid-1;
            }
        }
        return mini;
    }
}