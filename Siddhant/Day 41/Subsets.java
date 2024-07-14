class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> nm=new ArrayList<>();
        task(nm,new ArrayList<>(),0,nums);
        return nm;
    }
    
    private void task(List<List<Integer>> nm, List<Integer> kk, int ind, int nums[])
    {
        if(ind == nums.length)
        {
            nm.add(new ArrayList<>(kk));
            return;
        }
        task(nm,kk,ind+1,nums);
        kk.add(nums[ind]);
        task(nm,kk,ind+1,nums);
        kk.remove(kk.size()-1);
    }
}