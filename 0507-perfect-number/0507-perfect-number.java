class Solution {
    public boolean checkPerfectNumber(int num) {
        // int n = num/2,sum = 0;
        // for(int i = 1; i<=n; i++){
        //    if(num%i == 0){
        //     sum +=i;
        //    }
        // }
        // return num == sum;
        if (num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336) {
            return true;
        } else {
            return false;
        }
    }
}