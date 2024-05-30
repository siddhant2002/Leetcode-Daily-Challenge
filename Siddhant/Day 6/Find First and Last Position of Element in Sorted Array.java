class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower=lower_bound(nums,target);
        int upper=upper_bound(nums,target);
        int ans[]=new int[2];
        ans[0]=ans[1]=-1;
        if(lower<nums.length && nums[lower]==target)
        {
            ans[0]=lower;
            ans[1]=upper-1;
        }
        return ans;
    }
    private int lower_bound(int nums[], int target)
    {
        int i=0,j=nums.length-1;
        int val=j+1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(nums[mid]>=target)
            {
                j=mid-1;
                val=mid;
            }
            else
            {
                i=mid+1;
            }
        }
        return val;
    }
    private int upper_bound(int nums[], int target)
    {
        int i=0,j=nums.length-1;
        int val=j+1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(nums[mid]>target)
            {
                j=mid-1;
                val=mid;
            }
            else
            {
                i=mid+1;
            }
        }
        return val;
    }
}