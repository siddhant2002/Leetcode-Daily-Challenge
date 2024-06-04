class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1,len=nums.length;
        for(int i=len-2; i>=0; i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        if(ind==-1)
        {
            Arrays.sort(nums);
            return;
        }
        for(int i=len-1; i>=ind; i--)
        {
            if(nums[i]>nums[ind])
            {
                int dup=nums[i];
                nums[i]=nums[ind];
                nums[ind]=dup;
                break;
            }
        }
        List<Integer> nm=new ArrayList<>();
        for(int i=ind+1;i<len;i++)
        {
            nm.add(nums[i]);
        }
        Collections.sort(nm);
        for(int i=ind+1,j=i;i<len;i++)
        {
            nums[i]=nm.get(i-j);
        }
    }
}