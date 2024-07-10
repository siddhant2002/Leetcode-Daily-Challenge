class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int a[][]=task(grid,'X');
        int b[][]=task(grid,'Y');
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==b[i][j] && b[i][j]>0)
                {
                    count++;
                }
            }
        }
        return count;
    }
    private int[][] task(char[][] grid, char target)
    {
        int a[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                a[i][j] = grid[i][j] == target ? 1 : 0;
                a[i][j]+= i>0 ? a[i-1][j] : 0;
                a[i][j]+= j>0 ? a[i][j-1] : 0;
                a[i][j]-= i>0 && j>0 ? a[i-1][j-1] : 0;
            }
        }
        return a;
    }
}