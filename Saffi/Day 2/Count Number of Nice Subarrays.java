class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Replace odd number with a 1 and even with a 0
        // Now we have to just find the count of subarrays with sum k
        // The problem now becomes similar to that of the binary subarrays problem

        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & 1) == 0) nums[i] = 0;
            else nums[i] = 1;
        }

        return task(nums, k) - task(nums, k - 1);
    }

    static int task(int[] nums, int goal) {
        if(goal < 0) return 0;

        int l = 0, r = 0, count = 0, sum = 0;

        while(r < nums.length) {
            sum += nums[r];

            while(sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);

            r++;
        }

        return count;
    }
}