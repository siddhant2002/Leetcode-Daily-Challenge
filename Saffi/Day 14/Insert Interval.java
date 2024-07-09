class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s = newInterval[0], e = newInterval[1];

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        int i = 0;

        for(i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < s) {
                ArrayList<Integer> temp = new ArrayList<>();

                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);

                al.add(temp);
            }
            else if(intervals[i][0] > e) {
                break;
            }
            else if(intervals[i][1] >= s) {
                s = Math.min(intervals[i][0], s);
                e = Math.max(intervals[i][1], e);
            }
        }

        ArrayList<Integer> t = new ArrayList<>();
        t.add(s);
        t.add(e);
        al.add(t);

        for(; i < intervals.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            al.add(temp);
        }

        int[][] ans = new int[al.size()][2];

        for(i = 0; i < al.size(); i++) {
            ans[i][0] = al.get(i).get(0);
            ans[i][1] = al.get(i).get(1);
        }

        return ans;
    }
}