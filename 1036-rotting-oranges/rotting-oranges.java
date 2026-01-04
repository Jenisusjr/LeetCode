import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        // Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;

            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                for (int[] d : dir) {
                    int ni = cur[0] + d[0];
                    int nj = cur[1] + d[1];

                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        fresh--;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
