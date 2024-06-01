class Solution {
    public int majorityElement(int[] nums) {
        int ans = 0, freq = 0;

        for(int i = 0; i < nums.length; i++) {
            if(freq == 0) {
                ans = nums[i];
                freq = 1;
            }
            else if(nums[i] == ans) {
                freq++;
            }
            else {
                freq--;
            }
        }
        return ans;
    }
}