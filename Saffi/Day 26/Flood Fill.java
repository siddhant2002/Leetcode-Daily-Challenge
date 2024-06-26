class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;

        int[][] ans = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = image[i][j];
            }
        }

        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};

        dfs(image, ans, sr, sc, m, n, image[sr][sc], color, row, col);

        return ans;

    }

    static void dfs(int[][] image, int[][] ans, int r, int c, int m, int n, int inicolor, int color, int[] row, int[] col) {

        ans[r][c] = color;

        for(int i = 0; i < 4; i++) {
            int newR = r + row[i];
            int newC = c + col[i];

            if(newR < 0 || newR == m || newC < 0 || newC == n) continue;

            if(image[newR][newC] == inicolor && ans[newR][newC] != color) {
                dfs(image, ans, newR, newC, m, n, inicolor, color, row, col);
            } 
        }
    }
}