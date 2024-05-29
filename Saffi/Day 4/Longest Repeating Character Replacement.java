class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, ans = 0, freq = 0;

        int hash[] = new int[26];

        while(right < s.length()) {
            hash[s.charAt(right) - 'A']++;

            freq = Math.max(freq, hash[s.charAt(right) - 'A']);

            if(right - left + 1 - freq > k) {
                hash[s.charAt(left) - 'A']--;

                left++;
            }

            if(right - left + 1 - freq <= k) {
                ans = Math.max(ans, right - left + 1);
            }

            right++;
        }

        return ans;
    }
}
