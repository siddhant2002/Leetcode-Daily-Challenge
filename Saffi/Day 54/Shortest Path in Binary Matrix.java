class Tuple {
    int distance, row, col;

    Tuple(int d, int r, int c) {
        distance = d;
        row = r;
        col = c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] dist = new int[n][n];

        for(int[] temp : dist) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }

        dist[0][0] = 1;

        Queue<Tuple> q = new ArrayDeque<>();

        q.offer(new Tuple(1, 0, 0));

        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;

            q.poll();

            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = col + j;

                    if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) continue;

                    if(grid[newRow][newCol] == 1) continue;

                    if(dist[row][col] + 1 < dist[newRow][newCol]) {
                        dist[newRow][newCol] = dist[row][col] + 1;

                        q.offer(new Tuple(dist[newRow][newCol], newRow, newCol));
                    }

                }
            }
        }

        return dist[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1][n - 1];
    }
}