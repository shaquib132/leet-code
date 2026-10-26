class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long totalSum = dfs(grid, i, j);
                    if (totalSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private long dfs(int[][] g, int r, int c) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] <= 0) {
            return 0L;
        }

        long val = g[r][c];
        g[r][c] = 0; // Mark as visited by setting to 0

        return val + dfs(g, r + 1, c) 
                   + dfs(g, r - 1, c) 
                   + dfs(g, r, c + 1) 
                   + dfs(g, r, c - 1);
    }
}