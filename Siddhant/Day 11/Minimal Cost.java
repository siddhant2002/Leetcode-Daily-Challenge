class Solution {
    public int minimizeCost(int arr[], int k) {
        int n=arr.length;
        int dp[]=new int[n];
        for(int i=1; i<n; i++)
        {
            int right = 10000;
            for(int j=1; j<=k; j++)
            {
                if(i >= j)
                {
                    right=Math.min(right, Math.abs(arr[i]-arr[i-j])+dp[i-j]);
                }
            }
            dp[i] = right;
        }
        return dp[n-1];
    }
}