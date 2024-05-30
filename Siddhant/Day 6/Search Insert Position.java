class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0])
        {
            return 0;
        }
        int len=nums.length;
        if(target>nums[len-1])
        {
            return len;
        }
        int i=0,j=len-1;
        while(i<j)
        {
            int mid=(i+j)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]<target)
            {
                i=mid+1;
            }
            else
            {
                j=mid;
            }
        }
        return i;
    }
}