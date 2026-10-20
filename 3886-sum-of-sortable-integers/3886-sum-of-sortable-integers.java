class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                if (canSort(nums, n, k)) {
                    totalSum += k;
                }
                int otherK = n / k;
                if (otherK != k && canSort(nums, n, otherK)) {
                    totalSum += otherK;
                }
            }
        }

        return totalSum;
    }

    private boolean canSort(int[] nums, int n, int k) {
        int numBlocks = n / k;
        int prevMax = Integer.MIN_VALUE;

        for (int b = 0; b < numBlocks; b++) {
            int start = b * k;
            int dropIdx = -1;
            for (int i = 0; i < k - 1; i++) {
                if (nums[start + i] > nums[start + i + 1]) {
                    if (dropIdx != -1) {
                        return false;
                    }
                    dropIdx = i;
                }
            }

            int blockMin, blockMax;

            if (dropIdx == -1) {
                blockMin = nums[start];
                blockMax = nums[start + k - 1];
            } else {
                if (nums[start + k - 1] > nums[start]) {
                    return false;
                }
                blockMin = nums[start + dropIdx + 1];
                blockMax = nums[start + dropIdx];
            }

            if (blockMin < prevMax) {
                return false;
            }

            prevMax = blockMax;
        }

        return true;
    }
}