class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        int prev1 = 0, prev = nums[0];

        for(int ind = 1; ind < n - 1; ind++) {
            int pick = nums[ind], notPick = 0;

            notPick = prev;

            pick += prev1;

            int curr = Math.max(pick, notPick);
            prev1 = prev;
            prev = curr;
        }

        int ans = prev;

        prev1 = 0;
        prev = nums[1];

        for(int ind = 2; ind < n; ind++) {
            int pick = nums[ind], notPick = 0;

            notPick = prev;

            pick += prev1;

            int curr = Math.max(pick, notPick);
            prev1 = prev;
            prev = curr;
        }

        return Math.max(ans, prev);
    }
}