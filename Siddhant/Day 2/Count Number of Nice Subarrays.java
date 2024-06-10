class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return task(nums,k)-task(nums,k-1);
    }
    private int task(int nums[], int k)
    {
        int sum=0,count=0;
        for(int i=0,j=0; i<nums.length; i++)
        {
            if((nums[i]&1)==1)
            {
                count++;
            }
            while(count>k)
            {
                if((nums[j]&1)==1)
                {
                    count--;
                }
                j++;
            }
            sum+=(i-j);
        }
        return sum;
    }
}
