class Solution {
    public boolean isValid(String s) {

        String a = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                a = a + ch;
            } 
            else {

                if (a.length() == 0) {
                    return false;
                }

                int x = a.length() - 1;
                char top = a.charAt(x);

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    a = a.substring(0, a.length() - 1);

                } else {
                    return false;
                }
            }
        }

        return a.length() == 0;
    }
}