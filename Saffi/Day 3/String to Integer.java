class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if(s.length() == 0) return 0;

        int sign = 1;

        if(s.charAt(0) == '-') {
            sign = -1;

            s = s.substring(1);
        }
        else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        long ans = 0;

        for(int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';

            if(d < 0 || d > 9) break;

            ans = ans * 10 + d;

            if(ans > (long)(Integer.MAX_VALUE) + 1) break;

        }

        ans *= sign;

        if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)ans;
    }
}