class Solution {
    public int reverse(int x) {

        int a = x;
        int ans = 0;

        if (a < 0) {
            a = -a;
        }

        while (a > 0) {

            int tem = a % 10;

            // Check overflow before multiplication
            if (ans > (Integer.MAX_VALUE - tem) / 10) {
                return 0;
            }

            ans = ans * 10 + tem;

            a = a / 10;
        }

        if (x < 0) {
            ans = -ans;
        }

        return ans;
    }
}