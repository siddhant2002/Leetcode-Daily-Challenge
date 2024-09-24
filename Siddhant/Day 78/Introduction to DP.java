class Solution {
    static int val=1000000007;
    static long topDown(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        long data = task(n, dp);
        return data;
    }
    static int task(int n, int dp[])
    {
        if(n == 0 || n==1)
        {
            return n;
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        return dp[n] = (task(n-1,dp)%val + task(n-2,dp)%val)%val;
    }
    static long bottomUp(int n) {
        long c=0,a=0,b=1;
        if(n==1)
        {
            return n;
        }
        for(int i=2;i<=n;i++)
        {
            c=(a+b)%val;
            a=b%val;
            b=c%val;
        }
        return c;
    }
}