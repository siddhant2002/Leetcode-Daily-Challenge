class Solution {
    public int maximumPoints(int arr[][], int n) {
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][1], Math.max(arr[0][0], arr[0][2]));
        for(int ind = 1; ind < n; ind++)
        {
            int maxi = 0;
            for(int prev_ind = 0; prev_ind <= 3; prev_ind++)
            {
                for(int i=0; i<3; i++)
                {
                    if(prev_ind != i)
                    {
                        dp[ind][prev_ind] = Math.max(dp[ind][prev_ind], arr[ind][i] + dp[ind-1][i]);
                    }
                }
            }
            
        }
        return dp[n-1][3];
    }
}

---------------------------------------------------------------------------------------------------------

class Solution {
    public int maximumPoints(int arr[][], int n) {
        int prev[] = new int[4];
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][1], Math.max(arr[0][0], arr[0][2]));
        for(int ind = 1; ind < n; ind++)
        {
            int cur[] = new int[4];
            for(int prev_ind = 0; prev_ind <= 3; prev_ind++)
            {
                for(int i=0; i<3; i++)
                {
                    if(prev_ind != i)
                    {
                        cur[prev_ind] = Math.max(cur[prev_ind], arr[ind][i] + prev[i]);
                    }
                }
            }
            prev = cur;
        }
        return prev[3];
    }
}