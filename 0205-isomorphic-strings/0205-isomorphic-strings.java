class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] a = new int[256];
        int[] b = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (a[c1] != b[c2]) {
                return false;
            }
            a[c1] = i + 1;
            b[c2] = i + 1;
        }

        return true;
    }
}