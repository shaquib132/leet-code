class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(n<1){
            return nums[n];
        }
        int ans =0;
        Arrays.sort(nums);
        return nums[n-k];
    }
}