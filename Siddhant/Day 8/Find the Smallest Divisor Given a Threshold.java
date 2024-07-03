class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi=nums[0],mini=1;
        for(int i:nums)
        {
            maxi=Math.max(i,maxi);
        }
        while(mini<=maxi)
        {
            int mid=(mini+maxi)/2;
            if(task(nums,threshold,mid))
            {
                maxi=mid-1;
            }
            else
            {
                mini=mid+1;
            }
        }
        return mini;
    }
    private boolean task(int nums[], int threshold, int div)
    {
        int sum=0;
        for(int i:nums)
        {
            // int val=i/div;
            // sum+=val*val==i ? val : val+1;
            sum+=Math.ceil((double)i/div);
        }
        return sum<=threshold;
    }
}