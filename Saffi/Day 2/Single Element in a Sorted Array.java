class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len=nums.length;
        if(len==1)
        {
            return nums[0];
        }
        if(nums[0]!=nums[1])
        {
            return nums[0];
        }
        if(nums[len-1]!=nums[len-2])
        {
            return nums[len-1];
        }
        int i=1,j=len-2;
        while(i <= j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
            {
                return nums[mid];
            }
            else if((nums[mid] == nums[mid-1] && mid%2==1) || (nums[mid] == nums[mid+1] && mid%2==0))
            {
                i=mid+1;
            }
            else
            {
                j=mid-1;
            }
        }
        return nums[i];
    }
}