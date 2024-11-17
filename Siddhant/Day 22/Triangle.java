class Solution {
    public int minimumTotal(List<List<Integer>> nm) {
        int n = nm.size();
        int prev[] = new int[n+1];
        for(int i=n-1; i>=0; i--)
        {
            int cur[] = new int[n+1];
            for(int j=nm.get(i).size()-1; j>=0; j--)
            {
                cur[j] = nm.get(i).get(j) + Math.min(prev[j+1], prev[j]);
            }
            prev = cur;
        }
        return prev[0];
    }
}