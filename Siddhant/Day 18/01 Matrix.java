class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> nm=new LinkedList<>();
        int m=mat.length, n=mat[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                {
                    nm.offer(new int[]{i,j,0});
                }
            }
        }
        int c=1;
        int dr[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!nm.isEmpty())
        {
            int size=nm.size();
            for(int i=1; i<=size; i++)
            {
                int arr[]=nm.poll();
                for(int val[]: dr)
                {
                    int x=arr[0]+val[0];
                    int y=arr[1]+val[1];
                    if(x>=0 && x<m && y>=0 && y<n && mat[x][y]==1)
                    {
                        mat[x][y]=-c;
                        nm.offer(new int[]{x,y,c});
                    }
                }
            }
            c++;
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]<0)
                {
                    mat[i][j]=-mat[i][j];
                }
            }
        }
        return mat;
    }
}