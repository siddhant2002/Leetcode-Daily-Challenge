class Solution {
    public int beautySum(String s) {
        int maxi=0;
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            int a[]=new int[26];
            for(int j=i;j<len;j++)
            {
                char c=s.charAt(j);
                a[c-'a']++;
                maxi+=task(a);
            }
        }
        return maxi;
    }
    private int task(int a[])
    {
        int high=0,low=501;
        for(int i=0;i<26;i++)
        {
            high=Math.max(a[i],high);
            low=a[i]!=0 ? Math.min(low,a[i]) : low;
        }
        return high-low;
    }
}