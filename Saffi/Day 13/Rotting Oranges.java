
class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int row[] = { 0, -1, 0, 1 };
        int col[] = { -1, 0, 1, 0 };

        int minute = 0, freshToRotten = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.peek().x;
                int j = q.peek().y;
                q.poll();

                for (int k = 0; k < 4; k++) {
                    int r = i + row[k];
                    int c = j + col[k];

                    if (r < 0 || r >= m || c < 0 || c >= n)
                        continue;

                    if (grid[r][c] == 1) {
                        q.offer(new Pair(r, c));
                        grid[r][c] = 2;
                        freshToRotten++;
                    }

                }
            }

            if (q.size() > 0)
                minute++;
        }

        if (freshToRotten != fresh)
            return -1;

        return minute;
    }
}