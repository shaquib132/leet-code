class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int  x = 0,j=n-1;
        for (int i =0;i<n;i++) {
            if (nums[i] % 2 == 0) {
                ans[x] = nums[i];
                x++;
            } else {
                ans[j]=nums[i];
                j--;
            }
        }
        return ans;
    }
}