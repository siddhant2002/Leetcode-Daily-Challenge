class Solve {
    int[] findTwoElement(int arr[], int n) {
        int val=0;
        for(int i=0;i<n;i++)
        {
            val^=arr[i];
            val^=(i+1);
        }
        int bitset=0;
        while(true)
        {
            if((val & (1<<bitset)) != 0)
            {
                break;
            }
            bitset++;
        }
        int zero=0,one=0;
        for(int i=0;i<n;i++)
        {
            if((arr[i]&(1<<bitset)) != 0)
            {
                one^=arr[i];
            }
            else
            {
                zero^=arr[i];
            }
            if(((i+1)&(1<<bitset)) != 0)
            {
                one^=(i+1);
            }
            else
            {
                zero^=(i+1);
            }
        }
        int count=0;
        for(int i:arr)
        {
            if(zero==i)
            {
                count++;
            }
        }
        return new int[]{count==2 ?  zero : one ,count==2 ? one : zero};
    }
}