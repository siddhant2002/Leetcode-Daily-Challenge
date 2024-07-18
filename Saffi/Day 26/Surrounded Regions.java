class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        int row[] = {-1, 0, 1, 0};
        int col[] = {0, -1, 0, 1};

        for(int i = 0; i < n; i++) {
            if(!vis[0][i] && board[0][i] == 'O') {
                dfs(0, i, board, vis, row, col, m, n);
            }
            if(!vis[m - 1][i] && board[m - 1][i] == 'O') {
                dfs(m - 1, i, board, vis, row, col, m, n);
            }
        }

        for(int i = 0; i < m; i++) {
            if(!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, board, vis, row, col, m, n);
            }
            if(!vis[i][n - 1] && board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, vis, row, col, m, n);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(int x, int y, char[][] board, boolean[][] vis, int[] row, int[] col, int m, int n) {
        vis[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newRow = x + row[i];
            int newCol = y + col[i];

            if(newRow < 0 || newRow == m || newCol < 0 || newCol == n || board[newRow][newCol] == 'X') {
                continue;
            }

            if(!vis[newRow][newCol]) {
                dfs(newRow, newCol, board, vis, row, col, m, n);
            }
        }
    }
}