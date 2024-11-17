class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int mini = 10000000;
        int m = matrix.length, n = matrix[m-1].length;
        int prev[] = new int[n];
        for(int i=0; i<n; i++)
        {
            prev[i] = matrix[0][i];
        }
        for(int i=1; i<m; i++)
        {
            int cur[] = new int[n];
            for(int j=0; j<n; j++)
            {
                int left = 10000;
                if(j > 0)
                {
                    left = prev[j-1];
                }
                int up = prev[j];
                int right = 10000;
                if(j+1 < n)
                {
                    right = prev[j+1];
                }
                cur[j] = matrix[i][j] + Math.min(left, Math.min(up, right));
            }
            prev = cur;
        }
        for(int i=0; i<n; i++)
        {
            mini = Math.min(mini, prev[i]);
        }
        return mini;
    }
}