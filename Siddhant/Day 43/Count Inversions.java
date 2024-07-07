class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        return task(arr,0,n-1);
    }
    private static long task(long arr[], int i, int j)
    {
        long count=0;
        if(i<j)
        {
            int mid=(i+j)/2;
            count+=task(arr,i,mid);
            count+=task(arr,mid+1,j);
            count+=task1(arr,i,mid,j);
        }
        return count;
    }
    private static long task1(long arr[], int start, int mid, int end)
    {
        int i=start,m=mid+1,k=0;
        long count=0;
        long b[]=new long[end-start+1];
        while(i<=mid && m<=end)
        {
            if(arr[i]>arr[m])
            {
                b[k++]=arr[m++];
                count+=(mid-i+1);
            }
            else
            {
                b[k++]=arr[i++];
            }
        }
        while(i<=mid)
        {
            b[k++]=arr[i++];
        }
        while(m<=end)
        {
            b[k++]=arr[m++];
        }
        for(int p=start;p<=end;p++)
        {
            arr[p]=b[p-start];
        }
        return count;
    }
}