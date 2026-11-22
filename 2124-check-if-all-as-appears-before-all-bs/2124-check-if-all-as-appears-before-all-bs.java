class Solution {
    public boolean checkString(String s) {
        int x = s.indexOf('b');
        if (x < 0) {
            return true;
        }
        for (int i = x + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return false;
            }
        }
        
        return true;
    }
}
