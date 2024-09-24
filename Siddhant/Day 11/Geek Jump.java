class Solution{
    public int minimumEnergy(int arr[],int n){
        int dp[]=new int[n];
        for(int i=1; i<n; i++)
        {
            int left = Math.abs(arr[i]-arr[i-1])+dp[i-1];
            int right = 10000;
            if(i > 1)
            {
                right=Math.abs(arr[i]-arr[i-2])+dp[i-2];
            }
            dp[i] = Math.min(left , right);
        }
        return dp[n-1];
    }
}