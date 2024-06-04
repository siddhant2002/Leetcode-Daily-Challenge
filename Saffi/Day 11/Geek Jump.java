class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        
        if(N == 1) return 0;
        
        int dp[] = new int[N];
        
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        
        for(int i = 2; i < N; i++){
            dp[i] = Math.min(dp[i - 1] + Math.abs(arr[i] - arr[i - 1]), dp[i - 2] + Math.abs(arr[i] - arr[i - 2]));
        }
        
        return dp[N - 1];
        
        // return task(arr, N - 1, dp);
    }
    
    static int task(int[] arr, int N, int[] dp) {
        if(N == 1) {
            return Math.abs(arr[1] - arr[0]);
        }
        
        if(N == 0) {
            return 0;
        }
        
        if(dp[N] != -1) return dp[N];
        
        int one = Math.abs(arr[N] - arr[N - 1]) + task(arr, N - 1, dp);
        
        int two = Math.abs(arr[N] - arr[N - 2]) + task(arr, N - 2, dp);
        
        return dp[N] = Math.min(one, two);
    }
}