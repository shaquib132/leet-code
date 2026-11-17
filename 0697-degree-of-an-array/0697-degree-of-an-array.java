class Solution {
    public int findShortestSubArray(int[] nums) {
        int a = 0;
        for (int x : nums) {
            if (x > a) a = x;
        }

        int[] count = new int[a + 1];
        int[] first = new int[a + 1];
        int degree = 0, minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (count[x] == 0) {
                first[x] = i;
            }
            count[x]++;

            if (count[x] > degree) {
                degree = count[x];
                minLen = i - first[x] + 1;
            } else if (count[x] == degree) {
                minLen = Math.min(minLen, i - first[x] + 1);
            }
        }

        return minLen;
    }
}