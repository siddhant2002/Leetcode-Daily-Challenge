class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int dp[]=new int[2];
        int dp1[]=new int[2];
        for(int ind=len-1; ind>=0; ind--)
        {
            int cur[]=new int[2];
            for(int buy=0; buy<2; buy++)
            {
                if(buy==1)
                {
                    cur[buy] = Math.max(-prices[ind]+dp[0],dp[1]);
                }
                else
                {
                    cur[buy] = Math.max(prices[ind]+dp1[1],dp[0]);
                }
            }
            dp1=dp;
            dp=cur;
        }
        return dp[1];
    }
}