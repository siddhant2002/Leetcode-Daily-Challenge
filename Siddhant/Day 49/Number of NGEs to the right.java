class Solution {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int ans[]=new int[queries];
        for(int i=0;i<queries;i++)
        {
            ans[i]=task(arr,indices[i],N);
        }
        return ans;
    }
    
    private static int task(int arr[], int ind, int n)
    {
        int val=arr[ind];
        int count=0;
        for(int i=ind+1;i<n;i++)
        {
            if(arr[i]>val)
            {
                count++;
            }
        }
        return count;
    }
  }