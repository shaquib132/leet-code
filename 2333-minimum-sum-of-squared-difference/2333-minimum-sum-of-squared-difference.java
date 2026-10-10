class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        long k = (long) k1 + k2;
        if (totalDiff <= k) {
            return 0;
        }
        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }
        for (int v = maxDiff; v > 0 && k > 0; v--) {
            if (count[v] == 0) continue;

            if (k >= count[v]) {
                k -= count[v];
                count[v - 1] += count[v];
                count[v] = 0;
            } else {
                count[v - 1] += k;
                count[v] -= k;
                k = 0;
            }
        }
        long ans = 0;
        for (int v = 1; v <= maxDiff; v++) {
            if (count[v] > 0) {
                ans += (long) count[v] * (long) v * v;
            }
        }

        return ans;
    }
}