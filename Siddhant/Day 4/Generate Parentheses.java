class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        task(ans,n,n,"");
        return ans;
    }
    private void task(List<String> ans, int open, int close, String nm)
    {
        if(open==0 && close==0)
        {
            ans.add(nm);
            return;
        }
        if(open!=0)
        {
            String open1=nm+"(";
            task(ans,open-1,close,open1);
        }
        if(close>open)
        {
            String open2=nm+")";
            task(ans,open,close-1,open2);
        }
    }
}