class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	   // long dp[][] = new long[n][sum + 1];
        
    //     for(long[] temp : dp) {
    //         Arrays.fill(temp, -1);
    //     }
        
    //     return (int)(task(n - 1, n, arr, sum, dp) % 1000000007);
    
        // long dp[][] = new long[n][sum + 1];
        long prev[] = new long[sum + 1];
        
        if(arr[0] == 0) {
            // dp[0][0] = 2;
            prev[0] = 2;
        }
        else {
            // dp[0][0] = 1;
            prev[0] = 1;
        }
        
        if(arr[0] != 0 && arr[0] <= sum) {
            // dp[0][arr[0]] = 1;
            prev[arr[0]] = 1;
        }
        
        for(int ind = 1; ind < n; ind++) {
            long[] curr = new long[sum + 1];
            
            for(int s = 0; s <= sum; s++) {
                long pick = 0, notPick = 0;
        
                // notPick = dp[ind - 1][s];
                notPick = prev[s];
        
                if(s >= arr[ind]) {
                    // pick = dp[ind - 1][s - arr[ind]];
                    pick = prev[s - arr[ind]];
                }
        
                // dp[ind][s] = (notPick + pick) % 1000000007;
                curr[s] = (notPick + pick) % 1000000007;
            }
            
            prev = curr;
        }
        
        // return (int)dp[n - 1][sum];
        return (int)prev[sum];
	} 
	
	static long task(int ind, int n, int[] arr, int sum, long[][] dp) {
        
        if(ind == 0){
            if(sum == 0 && arr[0] == 0)
                return 2;
            if(sum == 0 || sum == arr[0])
                return 1;
            return 0;
        }
        
        if(dp[ind][sum] != -1) return dp[ind][sum];
        
        long pick = 0, notPick = 0;
        
        notPick = task(ind - 1, n, arr, sum, dp);
        
        if(sum >= arr[ind]) {
            pick = task(ind - 1, n, arr, sum - arr[ind], dp);
        }
        
        return dp[ind][sum] = (notPick + pick) % 1000000007;
    }
}