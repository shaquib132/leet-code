class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Arrays.sort(words);
        String ans = "";
        for (String w : words) {
            if (w.length() < ans.length() || (w.length() == ans.length() && w.compareTo(ans) >= 0)) {
                continue;
            }
            boolean Exist = true;
            for (int len = 1; len < w.length(); len++) {
                String prefix = w.substring(0, len);
                if (Arrays.binarySearch(words, prefix) < 0) {
                    Exist = false;
                    break;
                }
            }
            if (Exist) {
                ans = w;
            }
        }

        return ans;
    }
}
