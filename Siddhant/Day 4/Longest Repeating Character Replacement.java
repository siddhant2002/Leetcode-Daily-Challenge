class Solution {
    public int characterReplacement(String s, int k) {
        int a[]=new int[26];
        int ans=0,len=s.length(),max_freq=0;
        for(int i=0,j=0;i<len;i++)
        {
            char c=s.charAt(i);
            a[c-'A']++;
            max_freq=Math.max(max_freq,a[c-'A']);
            if(i-j+1-max_freq <= k)
            {
                ans=Math.max(ans,i-j+1);
            }
            else
            {
                while(i-j+1-max_freq > k)
                {
                    a[s.charAt(j++)-'A']--;
                    max_freq=0;
                    for(int j1=0;j1<26;j1++)
                    {
                        max_freq=Math.max(max_freq,a[j1]);
                    }
                }
            }
        }
        return ans;
    }
}