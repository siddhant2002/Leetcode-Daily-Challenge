class Solution {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        int dp[][]=new int[2][k+1];
        for(int ind=len-1; ind>=0; ind--)
        {
            int cur[][]=new int[2][k+1];
            for(int buy=0; buy<2; buy++)
            {
                for(int cap=1; cap<=k; cap++)
                {
                    if(buy==1)
                    {
                        cur[buy][cap] = Math.max(-prices[ind]+dp[0][cap],dp[1][cap]);
                    }
                    else
                    {
                        cur[buy][cap] = Math.max(prices[ind]+dp[1][cap-1],dp[0][cap]);
                    }
                }
            }
            dp=cur;
        }
        return dp[1][k];
    }
}