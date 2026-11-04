class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n];

        Comparator<Integer> cmp = (a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        };

        TreeSet<Integer> lower = new TreeSet<>(cmp);
        TreeSet<Integer> upper = new TreeSet<>(cmp);

        long sumLower = 0;
        long sumUpper = 0;

        int targetLower = (x + 1) / 2;

        for (int i = 0; i < n; i++) {

            // Insert current element
            if (lower.isEmpty() ||
                cmp.compare(i, lower.last()) <= 0) {

                lower.add(i);
                sumLower += nums[i];

            } else {
                upper.add(i);
                sumUpper += nums[i];
            }

            // Remove element outside window
            if (i >= x) {
                int outIdx = i - x;

                if (lower.remove(outIdx)) {
                    sumLower -= nums[outIdx];
                } else {
                    upper.remove(outIdx);
                    sumUpper -= nums[outIdx];
                }
            }

            // Balance both sets
            while (lower.size() > targetLower) {
                int last = lower.pollLast();

                sumLower -= nums[last];
                upper.add(last);
                sumUpper += nums[last];
            }

            while (lower.size() < targetLower &&
                   !upper.isEmpty()) {

                int first = upper.pollFirst();

                sumUpper -= nums[first];
                lower.add(first);
                sumLower += nums[first];
            }

            // Calculate window cost
            if (i >= x - 1) {

                long median = nums[lower.last()];

                long lCount = lower.size();
                long rCount = upper.size();

                long curCost =
                    (median * lCount - sumLower) +
                    (sumUpper - median * rCount);

                cost[i] = curCost;
            }
        }

        // Dynamic Programming
        long INF = (long) 1e18;

        long[] prevDp = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            long[] currDp = new long[n + 1];
            Arrays.fill(currDp, INF);

            for (int i = j * x; i <= n; i++) {

                long pick = prevDp[i - x] + cost[i - 1];

                currDp[i] = Math.min(
                    currDp[i - 1],
                    pick
                );
            }

            prevDp = currDp;
        }

        return prevDp[n];
    }
}
