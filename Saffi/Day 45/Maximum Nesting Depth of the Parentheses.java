class Solution {
    public int maxDepth(String s) {
        int ans = 0;

        int freq = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                freq++;
            }
            else if(c == ')') {
                ans = Math.max(ans, freq);
                freq--;
            }
        }

        return ans;
    }
}