class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;

        for(int i : nums) {
            right = Math.max(right, i);
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            long sum = task(nums, mid);

            if(sum > threshold) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    static long task(int[] nums, int n) {
        long sum = 0;

        for(int i : nums) {
            sum += i / n;

            if(i % n != 0) {
                sum++;
            }
        }

        return sum;
    }
}