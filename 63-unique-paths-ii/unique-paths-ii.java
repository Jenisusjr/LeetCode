class Solution {
    int function(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = function(obstacleGrid, m - 1, n, dp) + function(obstacleGrid, m, n - 1, dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return function(obstacleGrid, m - 1, n - 1, dp);
    }
}