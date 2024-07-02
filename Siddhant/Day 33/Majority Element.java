class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0],val=1;
        for(int i=1;i<nums.length;i++)
        {
            if(ele==nums[i])
            {
                val++;
            }
            else
            {
                val--;
                if(val==0)
                {
                    ele=nums[i];
                    val=1;
                }
            }
        }
        return ele;
    }
}