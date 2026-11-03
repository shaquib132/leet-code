class Solution {
    public int minMoves(int[] nums) {
        int max =Integer.MIN_VALUE,n=nums.length,sum =0;
        if(n<1){
            return 0;
        }
        for(int i =0 ; i<n;i++){
            sum+=nums[i];
            if(nums[i]>max){
                max = nums[i];
            }
        }
        
        return max*n-sum;
    }
}