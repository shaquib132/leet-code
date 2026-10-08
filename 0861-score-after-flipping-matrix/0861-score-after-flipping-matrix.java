class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int score = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int sameAsFirstColCount = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == grid[i][0]) {
                    sameAsFirstColCount++;
                }
            }
            int maxOnes = Math.max(sameAsFirstColCount, m - sameAsFirstColCount);
            score += maxOnes * (1 << (n - 1 - j));
        }
        return score;
    }
}