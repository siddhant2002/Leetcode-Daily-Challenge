class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;

        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[mid]) {
                ans = Math.min(nums[low], ans);
                low = mid + 1;
            }
            else if(nums[mid] <= nums[high]) {
                ans = Math.min(nums[mid], ans);
                high = mid - 1;
            }
        }

        return ans;
    }
}