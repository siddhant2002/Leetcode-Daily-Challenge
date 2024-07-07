class Solution {
    public int passThePillow(int n, int time) {
        int dup=1,count=1;
        while(time>0)
        {
            if(count==1 && dup<=n)
            {
                if(dup==n)
                {
                    count=0;
                    dup=n-1;
                }
                else
                {
                    dup++;
                }
            }
            else
            {
                if(dup==1)
                {
                    count=1;
                    dup=2;
                }
                else
                {
                    dup--;
                }
            }
            time--;
        }
        return dup;
    }
}