class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; 
        if (val > n) return -1;

        int left = Integer.MAX_VALUE, right = 0;

        for(int i : bloomDay) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int count = task(bloomDay, mid, k);

            if(count < m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    static int task(int[] bloomDay, int n, int k) {
        int temp = 0;
        int count = 0;

        for(int i : bloomDay) {
            if(i <= n) {
                temp++;
            }
            else {
                count += temp / k;
                temp = 0;
            }
        }

        count += temp / k;

        return count;
    }
}