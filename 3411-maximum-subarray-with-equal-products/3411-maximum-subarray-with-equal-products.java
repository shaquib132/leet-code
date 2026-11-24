class Solution {
    public int maxLength(int[] nums) {
        int maxLen = 2; 
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (gcd(prod, nums[right]) != 1) {
                prod /= nums[left];
                left++;
            }
            prod *= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
