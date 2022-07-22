// Two pointer
class Solution {
    public String reverseOnlyLetters(String s) {
      char [] A = s.toCharArray();
        int start=0;
        int end=s.length()-1;
        while(start<end)
        {
            if(!Character.isLetter(A[start])){
                start++;
            }else if(!Character.isLetter(A[end])){
                end--;
            }     
            else
            {
                char temp=A[start];
                A[start]=A[end];
                A[end]=temp;
                start++;
                end--;
            }
     }
      return new String(A);                           
    }
}