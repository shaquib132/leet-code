class Solution {
    public boolean detectCapitalUse(String word) {
        int x = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                x++;
            }
        }
        if (x == n || x == 0) {
            return true;
        }
        if (x == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        
        return false;
    }
}
