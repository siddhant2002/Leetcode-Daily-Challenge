class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        StringBuilder nm=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(i==0 && (c=='-' || c=='+'))
            {
                continue;
            }
            if(c>='0' && c<='9')
            {
                if(c=='0')
                {
                    if(count>0)
                    {
                        nm.append("0");
                    }
                }
                else
                {
                    nm.append(c);
                    count++;
                }
                long val=nm.length() > 0 ? Long.parseLong(nm.toString()) : 0;
                if(val<Integer.MIN_VALUE || val>Integer.MAX_VALUE)
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }
        long val=nm.length() > 0 ? Long.parseLong(nm.toString()) : 0;
        if(val>Integer.MAX_VALUE)
        {
            return s.charAt(0)=='-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return nm.length() == 0 ? 0 : s.charAt(0)=='-' ? (int)(-val) : (int)val ;
    }
}