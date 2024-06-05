class Solution{
    public int minimizeCost(int arr[],int N,int K){
        //code here

        int dp[] = new int[N];
        
        dp[0] = 0;
        
        for(int i = 1; i < N; i++){
            
            int min = Integer.MAX_VALUE;
            
            for(int j = 1; j <= K; j++) {
                if(i - j < 0) break;
                
                min = Math.min(min, dp[i - j] + Math.abs(arr[i] - arr[i - j]));
            }
            dp[i] = min;
        }
        
        return dp[N - 1];
    }
}
