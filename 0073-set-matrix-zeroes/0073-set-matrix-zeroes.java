class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        boolean firstColHasZero = false;
        boolean firstRowHasZero = false;

        // Check if first column has any zero
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Check if first row has any zero
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Zero out cells based on markers (start from 1 to preserve markers)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (firstRowHasZero) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (firstColHasZero) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }
}