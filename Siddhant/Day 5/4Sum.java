class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> nm=new ArrayList<>();
        for(int i=0;i<len-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j=i+1;j<len-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                {
                    continue;
                }
                int low=j+1,high=len-1;
                while(low<high)
                {
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[low]+(long)nums[high];
                    if(sum<Integer.MIN_VALUE || sum>Integer.MAX_VALUE)
                    {
                        break;
                    }
                    //System.out.println(sum);
                    if((int)sum==target)
                    {
                        nm.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1])
                        {
                            low++;
                        }
                        while(low<high && nums[high]==nums[high-1])
                        {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if((int)sum<target)
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                }
            }
        }
        return nm;
    }
}