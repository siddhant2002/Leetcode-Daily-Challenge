class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;

        int ans = 0;

        for(int i = prices.length - 1; i >= 0; i--) {
            if(prices[i] <= max) {
                ans = Math.max(ans, max - prices[i]);
            }
            else {
                max = prices[i];
            }
        }

        return ans;
    }
}