class Solution {
    public boolean lemonadeChange(int[] bills) {
        int a=0,b=0,c=0;
        for(int i:bills)
        {
            if(i==5)
            {
                a++;
            }
            else if(i==10)
            {
                if(a==0)
                {
                    return false;
                }
                a--;
                b++;
            }
            else
            {
                if(b==0)
                {
                    if(a<=2)
                    {
                        return false;
                    }
                    else
                    {
                        a-=3;
                    }
                }
                else
                {
                    if(a==0)
                    {
                        return false;
                    }
                    a--;
                    b--;
                }
            }
        }
        return true;
    }
}