class Solution {
    public boolean isUgly(int n) {
       if(n==0){
           return false;
       }
        if(n==1){
            return true;
        }
      return (n%2==0 && isUgly(n/2) ||
         n%3==0 && isUgly(n/3) ||
         n%5==0 && isUgly(n/5));

    }
}