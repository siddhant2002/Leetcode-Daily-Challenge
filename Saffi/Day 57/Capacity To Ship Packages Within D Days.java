class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long left = 1, right = 0;

        for(int i : weights) {
            right += i;
        }

        while(left <= right) {
            long mid = left + (right - left) / 2;

            int count = task(weights, mid);

            if(count > days) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return (int)left;
    }

    static int task(int[] weights, long n) {

        for(int i : weights) {
            if(n < i) return Integer.MAX_VALUE;
        }

        int count = 1;

        long temp = n;

        for(int i = 0; i < weights.length; i++) {
            if(weights[i] <= temp) {
                temp -= weights[i];
            }
            else {
                count++;

                temp = n - weights[i];
            }
        }
        return count;
    }
}