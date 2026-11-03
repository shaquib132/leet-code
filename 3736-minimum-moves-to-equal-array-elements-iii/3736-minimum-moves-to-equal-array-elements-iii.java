class Solution {
    public int minMoves(int[] nums) {
        int moves =0,n=nums.length;
        if(n<1){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
          moves+= nums[n-1]-nums[i];
        }
        return moves;
    }
}