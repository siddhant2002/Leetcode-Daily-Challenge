class Tuple {
    int diff, row, col;

    Tuple(int d, int r, int c) {
        diff = d;
        row = r;
        col = c;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length, n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int[] temp : dist) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.diff - y.diff);

        pq.offer(new Tuple(dist[0][0], 0, 0));

        int r[] = {-1, 0, 1, 0};
        int c[] = {0, -1, 0, 1};

        while(!pq.isEmpty()) {
            int row = pq.peek().row;
            int col = pq.peek().col;
            int diff = pq.peek().diff;

            if(row == m - 1 && col == n - 1) return diff;

            pq.poll();

            for(int i = 0; i <= 3; i++) {
                int newRow = row + r[i];
                int newCol = col + c[i];

                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;

                int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);

                if(newEffort < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newEffort;
                    pq.offer(new Tuple(dist[newRow][newCol], newRow, newCol));
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}