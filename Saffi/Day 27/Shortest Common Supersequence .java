class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();

        // int dp[][] = new int[l1][l2];

        // for(int[] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // return task(l1 - 1, l2 - 1, text1, text2, dp);

        int dp[][] = new int[l1 + 1][l2 + 1];

        if(text1.charAt(0) == text2.charAt(0)) {
            dp[1][1] =  1;
        }

        for(int ind1 = 1; ind1 <= l1; ind1++) {
            for(int ind2 = 1; ind2 <= l2; ind2++) {
                int ans = 0;

                if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    ans = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else {
                    ans = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }

                dp[ind1][ind2] = ans;

            }

        }

        // return dp[l1][l2];

        int len = dp[l1][l2];

        int ind1 = l1, ind2 = l2;

        StringBuilder str = new StringBuilder("");

        while(ind1 > 0 && ind2 > 0) {
            if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                str.append(text1.charAt(ind1 - 1));
                ind1--;
                ind2--;
            }
            else if(dp[ind1 - 1][ind2] > dp[ind1][ind2 - 1]) {
                str.append(text1.charAt(ind1 - 1));
                ind1--;
            }
            else {
                str.append(text2.charAt(ind2 - 1));
                ind2--;
            }
        }

        while(ind1 > 0) {
            str.append(text1.charAt(ind1 - 1));
            ind1--;
        }

        while(ind2 > 0) {
            str.append(text2.charAt(ind2 - 1));
            ind2--;
        }

        return str.reverse().toString();
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