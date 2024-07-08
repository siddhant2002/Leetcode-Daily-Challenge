class Solution {
    public int maxDepth(String s) {
        int maxi=0,count=0;
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                count++;
                maxi=Math.max(maxi,count);
            }
            else if(c==')')
            {
                count--;
            }
        }
        return maxi;
    }
}