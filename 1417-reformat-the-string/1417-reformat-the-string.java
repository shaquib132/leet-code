class Solution {
    public String reformat(String s) {
        char[] letters = new char[s.length()];
        char[] digits = new char[s.length()];
        int l = 0, d = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits[d++] = c;
            } else {
                letters[l++] = c;
            }
        }

        if (Math.abs(l - d) > 1) {
            return "";
        }

        boolean letterFirst = l >= d;
        char[] res = new char[s.length()];
        int i = 0, j = 0, k = 0;

        while (k < s.length()) {
            res[k++] = letterFirst ? letters[i++] : digits[j++];
            letterFirst = !letterFirst;
        }

        return new String(res);
    }
}