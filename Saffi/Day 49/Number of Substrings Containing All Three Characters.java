class Solution {
    public int numberOfSubstrings(String s) {
        int ind[] = new int[3];

        Arrays.fill(ind, -1);

        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            ind[s.charAt(i) - 'a'] = i;

            if(ind[0] != -1 && ind[1] != -1 && ind[2] != -1) {
                ans += Math.min(ind[0], Math.min(ind[1], ind[2])) + 1;
            }
        }

        return ans;
    }
}