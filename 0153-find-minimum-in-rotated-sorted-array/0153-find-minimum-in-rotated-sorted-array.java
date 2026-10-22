class Solution {
    public int findMin(int[] nums) {
        int x =100000;
       for(int i =0;i<nums.length;i++){
         x= Math.min(x,nums[i]);
       }
       return x;
    }
}