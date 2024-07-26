class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        for(int i : nums) {
            left = Math.max(i, left);
            right += i;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int count = task(nums, mid);

            if(count > k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    static int task(int[] nums, int n) {
        int temp = 0;
        int count = 1;

        for(int i = 0; i < nums.length; i++) {
            if(temp + nums[i] <= n) {
                temp += nums[i];
            }
            else {
                count++;
                temp = nums[i];
            }
        }

        return count;
    }
}