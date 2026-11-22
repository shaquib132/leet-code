class Solution {
    public boolean checkString(String s) {
        int x = s.indexOf('b');
        if(x<0){
            if(s.charAt(0)=='a'){
                return true;
            }
            return false;
        }
        for(int i=x+1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                return false;
            }
        }
        return true;
    }
}