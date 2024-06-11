class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> nm=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    nm.offer(new int[]{i,j,0});
                }
                else if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        int maxi=0,c=0;
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while(!nm.isEmpty())
        {
            int a[]=nm.poll();
            maxi=Math.max(maxi,a[2]);
            for(int i[]: dir)
            {
                int x=a[0]+i[0];
                int y=a[1]+i[1];
                if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==2 || grid[x][y]==0)
                {
                    continue;
                }
                else
                {
                    nm.offer(new int[]{x,y,a[2]+1});
                    grid[x][y]=2;
                    c++;
                }
            }
        }
        return c!=count ? -1 : maxi;
    }
}