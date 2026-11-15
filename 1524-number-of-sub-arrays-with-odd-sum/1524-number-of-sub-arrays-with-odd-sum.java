class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        long ans = 0;
        int odd = 0, even = 1, sum = 0;

        for (int x : arr) {
            sum += x;
            if ((sum & 1) == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
        }

        return (int) (ans % mod);
    }
}