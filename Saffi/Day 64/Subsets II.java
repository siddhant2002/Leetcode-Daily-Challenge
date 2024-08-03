class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        task(0, nums, ans, temp);

        return ans;
    }

    static void task(int ind, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list)); 
        for(int i = ind;i < nums.length; i++) {
            if(i != ind && nums[i] == nums[i - 1]) continue; 
            list.add(nums[i]); 
            task(i + 1, nums, ans, list); 
            list.remove(list.size() - 1);
        }
    }
}