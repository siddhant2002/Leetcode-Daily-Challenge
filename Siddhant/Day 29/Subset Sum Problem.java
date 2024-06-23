class Solution{
    static Boolean isSubsetSum(int N, int arr[], int target){
        boolean dp[]=new boolean[target+1];
        if(arr[0]<=target)
        {
            dp[arr[0]]=true;
        }
        dp[0]=true;
        for(int ind=1;ind<N;ind++)
        {
            boolean cur[]=new boolean[target+1];
            cur[0]=true;
            for(int sum=1;sum<=target;sum++)
            {
                boolean nottake=dp[sum];
                boolean take=false;
                if(sum>=arr[ind])
                {
                    take=dp[sum-arr[ind]];
                }
                cur[sum] = take||nottake;
            }
            dp=cur;
        }
        return dp[target];
    }
}