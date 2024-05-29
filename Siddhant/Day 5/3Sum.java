class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        List<List<Integer>> nm=new ArrayList<>();
        for(int i=0;i<len-2;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]))
            {
                int j=i+1,k=len-1;
                while(j<k)
                {
                    int sum=nums[i]+nums[j]+nums[k];
                    if(sum==0)
                    {
                        nm.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1])
                        {
                            j++;
                        }
                        while(j<k && nums[k]==nums[k-1])
                        {
                            k--;
                        }
                        j++;
                        k--;
                    }
                    else if(sum<0)
                    {
                        j++;
                    }
                    else
                    {
                        k--;
                    }
                }
            }
        }
        return nm;
    }
}