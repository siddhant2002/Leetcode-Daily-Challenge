class Solution {
    public int maxProfit(int[] prices) {
        int val=prices[0],maxi=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<val)
            {
                val=prices[i];
            }
            else
            {

                maxi=Math.max(maxi,prices[i]-val);
            }
        }
        return maxi;
    }
}