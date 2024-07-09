class Solution {
    public int beautySum(String s) {
        
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {

            int[] hash = new int[26];
            for(int j = i; j < s.length(); j++) {
                
                hash[s.charAt(j) - 'a']++;

                ans += beauty(hash);
            }
        }

        return ans;
    }

    static int beauty(int[] hash) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int k : hash) {
            if(k == 0) continue;

            min = Math.min(min, k);
            max = Math.max(max, k);
        }

        return max - min;
    }
}