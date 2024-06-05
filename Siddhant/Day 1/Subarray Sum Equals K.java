class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> nm=new HashMap<>();
        nm.put(0,1);
        int sum=0,ans=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(nm.containsKey(sum-k))
            {
                ans+=nm.get(sum-k);
            }
            nm.put(sum, nm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}