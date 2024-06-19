class Solution{
    static int searchInSorted(int arr[], int N, int K)
    {
        int i=0,j=N-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(arr[mid]==K)
            {
                return 1;
            }
            else if(arr[mid]<K)
            {
                i=mid+1;
            }
            else
            {
                j=mid-1;
            }
        }
        return -1;
    }
}