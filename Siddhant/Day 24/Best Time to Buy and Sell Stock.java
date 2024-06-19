class Solution {
    public int maxProfit(int[] prices) {
        int ans=0,val=prices[0];
        for(int i=0;i<prices.length;i++)
        {
            ans=Math.max(ans,prices[i]-val);
            val=Math.min(val,prices[i]);
        }
        return ans;
    }
}