class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> nm=new ArrayList<>();
        int prev=-1;
        int i=0,j=0;
        while(i<n && j<m)
        {
            if(arr1[i] == arr2[j] && arr1[i]==prev)
            {
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j])
            {
                if(arr1[i]!=prev)
                {
                    nm.add(arr1[i]);
                    prev=arr1[i];
                }
                i++;
            }
            else
            {
                if(arr2[j]!=prev)
                {
                    nm.add(arr2[j]);
                    prev=arr2[j];
                }
                j++;
            }
        }
        while(i<n)
        {
            if(arr1[i]!=prev)
            {
                nm.add(arr1[i]);
                prev=arr1[i];
            }
            i++;
        }
        while(j<m)
        {
            if(arr2[j]!=prev)
            {
                nm.add(arr2[j]);
                prev=arr2[j];
            }
            j++;
        }
        return nm;
    }
}