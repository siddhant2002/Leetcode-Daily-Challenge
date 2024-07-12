class Solution{
    public int maximumPoints(int points[][],int N){
        int dp[][]=new int[N+1][3];
        for(int i=0;i<3;i++)
        {
            dp[N-1][i]=points[N-1][i];
        }
        for(int ind=N-1;ind>=0;ind--)
        {
            for(int prev_ind=0;prev_ind<3;prev_ind++)
            {
                if(prev_ind==0)
                {
                    dp[ind][prev_ind] = Math.max(points[ind][1]+dp[ind+1][1], points[ind][2]+dp[ind+1][2]);
                }
                else if(prev_ind==1)
                {
                    dp[ind][prev_ind] = Math.max(points[ind][0]+dp[ind+1][0], points[ind][2]+dp[ind+1][2]);
                }
                else
                {
                    dp[ind][prev_ind] = Math.max(points[ind][1]+dp[ind+1][1], points[ind][0]+dp[ind+1][0]);
                }
            }
        }
        return Math.max(dp[0][0], Math.max(dp[0][1],dp[0][2]));
    }
}