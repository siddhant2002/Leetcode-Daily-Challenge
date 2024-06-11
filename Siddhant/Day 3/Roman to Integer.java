class Solution {
    public int romanToInt(String s) {
        int ans[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            ans[i]=task(c);
        }
        int sum=0;
        for(int i=0;i<ans.length-1;i++)
        {
            if(ans[i]<ans[i+1])
            {
                sum-=ans[i];
            }
            else
            {
                sum+=ans[i];
            }
        }
        return sum+ans[ans.length-1];
    }
    private int task(char ch)
    {
        switch(ch)
        {
            case 'I':
            return 1;
            // break;
            case 'V':
            return 5;
            // break;
            case 'X':
            return 10;
            // break;
            case 'L':
            return 50;
            // break;
            case 'C':
            return 100;
            // break;
            case 'D':
            return 500;
            // break;
            case 'M':
            return 1000;
            // break;
            default:
            return 0;
        }
    }
}