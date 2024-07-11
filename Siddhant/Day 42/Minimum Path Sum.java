class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i[]: dp)
        {
            Arrays.fill(i,-1);
        }
        return task(grid,m-1,n-1,dp);
    }
    private int task(int grid[][], int i, int j, int dp[][])
    {
        if(i<0 || j<0)
        {
            return Integer.MAX_VALUE;
        }
        if(i==0 && j==0)
        {
            return grid[i][j];
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        return dp[i][j] = grid[i][j] + Math.min(task(grid,i-1,j,dp), task(grid,i,j-1,dp));
    }
}