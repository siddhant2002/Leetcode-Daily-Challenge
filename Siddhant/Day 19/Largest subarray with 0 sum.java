class GfG
{
    int maxLen(int arr[], int n)
    {
        Map<Integer,Integer> nm=new HashMap<>();
        nm.put(0,0);
        int sum=0,maxi=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(nm.containsKey(sum))
            {
                maxi=Math.max(maxi,i-nm.get(sum));
                if(sum==0)
                {
                    maxi+=1;
                }
            }
            else
            {
                nm.put(sum,i);
            }
        }
        return maxi;
    }
}