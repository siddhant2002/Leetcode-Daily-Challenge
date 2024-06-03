class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0, spos = 0;

        for(int i = 0; i < g.length && spos < s.length; i++) {
            while(spos < s.length && g[i] > s[spos]) {
                spos++;
            }

            if(spos < s.length) {
                count++;
                spos++;
            }
        }

        return count;
    }
}