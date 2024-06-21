class Solution {
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || i==m-1 || j==0 || j==n-1)
                {
                    if(vis[i][j]==0 && board[i][j]=='O')
                    {
                        task(board,vis,i,j,m,n);
                    }
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
    private void task(char board[][], int vis[][], int i, int j, int m, int n)
    {
        if(i<0 || j<0 || j>=n || i>=m || vis[i][j]==1 || board[i][j]=='X')
        {
            return;
        }
        vis[i][j]=1;
        task(board,vis,i+1,j,m,n);
        task(board,vis,i-1,j,m,n);
        task(board,vis,i,j+1,m,n);
        task(board,vis,i,j-1,m,n);
    }
}