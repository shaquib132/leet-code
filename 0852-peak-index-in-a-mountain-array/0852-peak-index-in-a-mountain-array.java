class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int x =0,max=Integer.MIN_VALUE;
        for(int i =0; i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
                x=i;
            }
        }
        return x;
    }
}