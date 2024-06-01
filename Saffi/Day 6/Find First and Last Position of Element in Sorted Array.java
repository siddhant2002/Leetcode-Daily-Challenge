class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];

        ans[0] = lower(nums, target);
        ans[1] = upper(nums, target);

        return ans;
    }

    static int lower(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                if(nums[mid] == target) {
                    ans = mid;
                }
                high = mid - 1;
            }
        }

        return ans;
    }

    static int upper(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                if(nums[mid] == target) {
                    ans = mid;
                }
                low = mid + 1;
            }
        }
        return ans;
    }
}