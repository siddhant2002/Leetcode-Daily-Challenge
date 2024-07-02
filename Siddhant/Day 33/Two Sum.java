class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> nm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nm.containsKey(target-nums[i]))
            {
                return new int[]{nm.get(target-nums[i]),i};
            }
            nm.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}