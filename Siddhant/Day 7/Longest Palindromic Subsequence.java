class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder nm=new StringBuilder(s);
        nm.reverse();
        int m=s.length();
        int dp[][]=new int[m][m];
        for(int a[]: dp)
        {
            Arrays.fill(a,-1);
        }
        return task(s,nm.toString(),m-1,m-1,dp);
    }
    private int task(String text1, String text2, int ind1, int ind2, int dp[][])
    {
        if(ind1<0 || ind2<0)
        {
            return 0;
        }
        if(text1.charAt(ind1) == text2.charAt(ind2))
        {
            return 1+task(text1,text2,ind1-1,ind2-1,dp);
        }
        if(dp[ind1][ind2] != -1)
        {
            return dp[ind1][ind2];
        }
        return dp[ind1][ind2] = Math.max(task(text1,text2,ind1-1,ind2,dp), task(text1,text2,ind1,ind2-1,dp));
    }
}