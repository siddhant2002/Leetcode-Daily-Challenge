class Solution {
    public int longestPalindromeSubseq(String s) {
        String text1 = s;

        StringBuilder str = new StringBuilder(s);

        String text2 = str.reverse().toString();
    
        int l1 = text1.length(), l2 = text2.length();

        // int dp[][] = new int[l1][l2];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(l1 - 1, l2 - 1, text1, text2, dp);

        // int dp[][] = new int[l1][l2];
        int prev[] = new int[l2];

        if(text1.charAt(0) == text2.charAt(0)) {
            // dp[0][0] =  1;
            prev[0] =  1;
        }

        for(int ind1 = 0; ind1 < l1; ind1++) {
            int curr[] = new int[l2];
            for(int ind2 = 0; ind2 < l2; ind2++) {
                int ans = 0;

                if(text1.charAt(ind1) == text2.charAt(ind2)) {
                    ans = 1;
                    if(ind1 > 0 && ind2 > 0){
                        // ans += dp[ind1 - 1][ind2 - 1];
                        ans += prev[ind2 - 1];
                    }
                }
                else {
                    if(ind1 > 0) {
                        // ans = Math.max(ans, dp[ind1 - 1][ind2]);
                        ans = Math.max(ans, prev[ind2]);
                    }

                    if(ind2 > 0) {
                        // ans = Math.max(ans, dp[ind1][ind2 - 1]);
                        ans = Math.max(ans, curr[ind2 - 1]);
                    }
                }

                // dp[ind1][ind2] = ans;
                curr[ind2] = ans;
            }

            prev = curr;
        }

        // return dp[l1 - 1][l2 - 1];
        return prev[l2 - 1];
    }

    static int task(int ind1, int ind2, String text1, String text2, int[][] dp) {

        if(ind1 == 0 && ind2 == 0) {
            if(text1.charAt(0) == text2.charAt(0)) return 1;
            
            return 0;
        }

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        int ans = 0;

        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            ans = 1;
            if(ind1 > 0 && ind2 > 0){
                ans += task(ind1 - 1, ind2 - 1, text1, text2, dp);
            }
        }
        else {
            if(ind1 > 0) {
                ans = Math.max(ans, task(ind1 - 1, ind2, text1, text2, dp));
            }

            if(ind2 > 0) {
                ans = Math.max(ans, task(ind1, ind2 - 1, text1, text2, dp));
            }
        }

        return dp[ind1][ind2] = ans;
    }
}