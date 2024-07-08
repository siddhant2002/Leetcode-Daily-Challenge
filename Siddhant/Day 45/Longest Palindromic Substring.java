class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        boolean k[][]=new boolean[len][len];
        for(int i=0;i<len;i++)
        {
            k[i][i]=true;
        }
        for(int i=0;i<len-1;i++)
        {
            k[i][i+1]=s.charAt(i)==s.charAt(i+1);
        }
        for(int p=2;p<len;p++)
        {
            for(int j=0,i=p;i<len;j++,i++)
            {
                if(s.charAt(i)==s.charAt(j) && k[j+1][i-1])
                {
                    k[j][i]=true;
                }
            }
        }
        int maxi=0;
        int val[]=new int[2];
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(k[i][j] && (j-i+1)>maxi)
                {
                    maxi=j-i+1;
                    val[0]=i;
                    val[1]=j;
                }
            }
        }
        return s.substring(val[0],val[1]+1);
    }
}