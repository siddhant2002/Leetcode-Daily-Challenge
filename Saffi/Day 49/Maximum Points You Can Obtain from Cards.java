class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, n = cardPoints.length;

        for(int i : cardPoints) {
            sum += i;
        }

        int sum1 = 0;

        for(int i = 0; i < n - k; i++) {
            sum1 += cardPoints[i];
        }
        int ans = sum - sum1;

        for(int i = 1, j = n - k; j < n; i++, j++) {
            sum1 += cardPoints[j] - cardPoints[i - 1];

            ans = Math.max(sum - sum1, ans);
        }

        return ans;
    }
}