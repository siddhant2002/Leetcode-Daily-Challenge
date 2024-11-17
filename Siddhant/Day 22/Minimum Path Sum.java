class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int prev[] = new int[n];
        for(int i=0; i<m; i++)
        {
            int cur[] = new int[n];
            for(int j=0; j<n; j++)
            {
                if(i == 0 && j == 0)
                {
                    prev[j] = grid[i][j];
                    cur[j] = grid[i][j];
                }
                else
                {
                    int up = 100000;
                    if(i > 0)
                    {
                        up = prev[j];
                    }
                    int left = 100000;
                    if(j > 0)
                    {
                        left = cur[j-1];
                    }
                    cur[j] = grid[i][j] + Math.min(up, left); 
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}