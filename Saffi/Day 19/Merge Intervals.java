class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> al = new ArrayList<>();

        int i = 0;

        while(i < intervals.length) {
            int start = intervals[i][0], end = intervals[i][1];

            while(i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }

            int[] temp = new int[2];
            temp[0] = start;
            temp[1] = end;

            al.add(temp);
        }

        int[][] ans = new int[al.size()][2];

        int ind = 0;

        for(int[] it : al) {
            ans[ind++] = it;
        }

        return ans;
    }
}