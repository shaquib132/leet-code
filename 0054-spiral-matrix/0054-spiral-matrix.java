import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int minr = 0;
        int minc = 0;
        int maxr = matrix.length - 1;
        int maxc = matrix[0].length - 1;

        while (minr <= maxr && minc <= maxc) {

            // 1. Left to right (top row)
            for (int j = minc; j <= maxc; j++) {
                ans.add(matrix[minr][j]);
            }
            minr++;

            // 2. Top to bottom (right column)
            for (int i = minr; i <= maxr; i++) {
                ans.add(matrix[i][maxc]);
            }
            maxc--;

            // 3. Right to left (bottom row)
            if (minr <= maxr) {
                for (int j = maxc; j >= minc; j--) {
                    ans.add(matrix[maxr][j]);
                }
                maxr--;
            }

            // 4. Bottom to top (left column)
            if (minc <= maxc) {
                for (int i = maxr; i >= minr; i--) {
                    ans.add(matrix[i][minc]);
                }
                minc++;
            }
        }

        return ans;
    }
}