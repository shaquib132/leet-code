class Solution {
    public int[] shuffle(int[] nums, int n) {
        int s = 0, i = 0;
        int end = nums.length / 2;
        int[] result = new int[nums.length];
        
        while (i < nums.length) {
            if (i%2 == 0) {
                result[i] = nums[s];
                s++;
                i++;
            } else {
                result[i] = nums[end];
                end++;
                i++;
            }
            
        }
        return result;
    }
}