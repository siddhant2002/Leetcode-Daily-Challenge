class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        task(0, 0, "", n, ans);

        return ans;
    }

    static void task(int open, int close, String s, int n, List<String> ans) {
        if(open == n && close == n) {
            ans.add(s);
            return;
        }

        if(open < n) {
            task(open + 1, close, s + "(", n, ans);
        }

        if(close < open) {
            task(open, close + 1, s + ")", n, ans);
        }
    }
}