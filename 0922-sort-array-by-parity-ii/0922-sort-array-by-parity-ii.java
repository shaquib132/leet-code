class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j=1,x=0;
        for(int i = 0; i<n;i++){
         if(nums[i]%2==0){
            ans[x]=nums[i];
            x=x+2;
         }   else{
            ans[j]=nums[i];
            j=j+2;
         }
        }
        return ans;
    }
}