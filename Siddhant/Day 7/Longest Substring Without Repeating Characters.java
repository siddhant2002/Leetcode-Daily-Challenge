class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a[]=new int[256];
        int maxi=0,count=0;
        int i=0,j=0;
        for(;i<s.length();i++)
        {
            char c=s.charAt(i);
            a[c]++;
            count=Math.max(count,a[c]);
            if(count==2)
            {
                maxi=Math.max(maxi,i-j);
                while(a[c]==2)
                {
                    a[s.charAt(j)]--;
                    j++;
                }
                count=1;
            }
        }
        return Math.max(maxi,i-j);
    }
}