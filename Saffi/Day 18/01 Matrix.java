class Pair {
    int r, c;
    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int ans[][] = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        int ro[] = {-1, 0, 1, 0};
        int co[] = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().r;
            int col = q.peek().c;

            q.poll();

            for(int i = 0; i < 4; i++) {
                int newR = ro[i] + row;
                int newC = co[i] + col;

                if(newR < 0 || newR >= m || newC < 0 || newC >= n || mat[newR][newC] == 0) continue;

                mat[newR][newC] = 0;

                ans[newR][newC] = 1 + ans[row][col];

                q.offer(new Pair(newR, newC));
            }
        }

        return ans;
    }
}