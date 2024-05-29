class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) {
            return ans;
        }

        String s[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        char[] c = new char[digits.length()];
        task(digits, 0, ans, c, s);

        return ans;
    }

    static void task(String d, int pos, List<String> ans, char[] c, String[] s) {
        if(pos == d.length()) {
            ans.add(String.valueOf(c));
            return;
        }

        int n = d.charAt(pos) - '0';

        for(int i = 0; i < s[n].length(); i++) {
            c[pos] = s[n].charAt(i);

            task(d, pos + 1, ans, c, s);

            c[pos] = '0';
        }
    }
}