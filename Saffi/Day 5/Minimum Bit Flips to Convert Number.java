class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;

        int ans = 0;

        while(xor > 0) {
            if((xor & 1) != 0) ans++;

            xor = xor >> 1;
        }
        return ans;
    }
}