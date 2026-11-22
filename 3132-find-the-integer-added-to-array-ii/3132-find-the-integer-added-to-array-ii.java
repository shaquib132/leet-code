class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i >= 0; i--) {
            int x = nums2[0] - nums1[i];
            int j = 0;

            for (int num : nums1) {
                if (j < nums2.length && num + x == nums2[j]) {
                    j++;
                }
            }
            if (j == nums2.length) {
                return x;
            }
        }

        return -1;
    }
}
