class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for(int i : piles) {
            right = Math.max(right, i);
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            long hours = task(piles, mid);

            if(hours > h) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    static long task(int[] piles, int n) {
        long hours = 0;

        for(int i : piles) {
            hours += i / n;

            if(i % n != 0) {
                hours++;
            }
        }

        return hours;
    }
}