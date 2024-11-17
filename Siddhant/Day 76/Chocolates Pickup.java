class Solution {
    public int solve(int n, int m, int grid[][]) {
        int prev[][] = new int[m][m];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<m; j++)
            {
                prev[i][j] = i == j ? grid[n-1][j] : grid[n-1][j] + grid[n-1][i];
            }
        }
        for(int i=n-2; i>=0; i--)
        {
            int cur[][] = new int[m][m];
            for(int j1=0; j1<m; j1++)
            {
                for(int j2=0; j2<m; j2++)
                {
                    int maxi = 0;
                    for(int i1=-1; i1<=1; i1++)
                    {
                        int val = 0;
                        for(int i2=-1; i2<=1; i2++)
                        {
                            val = j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            int x = (i1+j1);
                            int y = (i2+j2);
                            if(x >= 0 && x < m && y >= 0 && y < m)
                            {
                                val += prev[x][y];
                            }
                            else
                            {
                                val = -10000;
                            }
                            maxi = Math.max(maxi, val);
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }
            prev = cur;
        }
        return prev[0][m-1];
    }
}