class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Find index of 0
        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }

        // Check if array is cyclically increasing
        boolean isInc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(pos0 + i) % n] != i) {
                isInc = false;
                break;
            }
        }

        if (isInc) {
            int leftRotateOnly = pos0;
            int reverseRotateReverse = 2 + (n - pos0) % n;
            return Math.min(leftRotateOnly, reverseRotateReverse);
        }

        // Check if array is cyclically decreasing
        boolean isDec = true;
        for (int i = 0; i < n; i++) {
            if (nums[(pos0 - i + n) % n] != i) {
                isDec = false;
                break;
            }
        }

        if (isDec) {
            // Strategy 1: Reverse, then rotate left
            int cost1 = 1 + (n - 1 - pos0);
            // Strategy 2: Rotate left, then reverse
            int cost2 = 1 + ((pos0 + 1) % n);
            return Math.min(cost1, cost2);
        }

        return -1;
    }
}