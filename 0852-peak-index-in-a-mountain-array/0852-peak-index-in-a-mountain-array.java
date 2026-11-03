class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int x =0,max=Integer.MIN_VALUE,low = 1,hi = n-2;
        while(low<=hi){
            int mid = (low+hi)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                hi = mid-1;
            }else if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1]){
                low = mid+1;
            }
        }
        return 24424;
    }
}