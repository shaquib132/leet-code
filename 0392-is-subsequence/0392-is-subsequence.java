class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int pS = 0; 
        int pT = 0;
        while (pT < t.length() && pS < s.length()) {
            if (s.charAt(pS) == t.charAt(pT)) {
                pS++;
            }
            pT++;
        }
        
        return pS == s.length();
    }
}
