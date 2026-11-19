class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = -1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int len = j - i + 1;

                if (len > r) break;

                if (len >= l && sum > 0) {
                    if (minSum == -1 || sum < minSum) {
                        minSum = sum;
                    }
                }
            }
        }

        return minSum;
    }
}