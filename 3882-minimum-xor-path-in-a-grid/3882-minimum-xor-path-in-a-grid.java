class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxXor = 1024;

        boolean[][] dp = new boolean[n][maxXor];

        dp[0][grid[0][0]] = true;

        // Process the first row
        for (int j = 1; j < n; j++) {
            int val = grid[0][j];

            for (int v = 0; v < maxXor; v++) {
                if (dp[j - 1][v]) {
                    dp[j][v ^ val] = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            boolean[][] nextDp = new boolean[n][maxXor];

            int firstColVal = grid[i][0];

            for (int v = 0; v < maxXor; v++) {
                if (dp[0][v]) {
                    nextDp[0][v ^ firstColVal] = true;
                }
            }

            for (int j = 1; j < n; j++) {
                int val = grid[i][j];

                for (int v = 0; v < maxXor; v++) {
                    if (dp[j][v] || nextDp[j - 1][v]) {
                        nextDp[j][v ^ val] = true;
                    }
                }
            }

            dp = nextDp;
        }

        for (int v = 0; v < maxXor; v++) {
            if (dp[n - 1][v]) {
                return v;
            }
        }

        return -1;
    }
}
