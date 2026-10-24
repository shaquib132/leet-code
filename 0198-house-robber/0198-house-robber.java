class Solution {
    public int rob(int[] nums) {
        int x = 0; // max money rob-able up to i - 2
        int y = 0; // max money rob-able up to i - 1

        for (int num : nums) {
            int current = Math.max(y, x + num);
            x = y;
            y = current;
        }

        return y;
    }
}