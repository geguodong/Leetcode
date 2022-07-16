class Solution {
    	public String reverseVowels(String s) {
		char[] ar = s.toCharArray();
		int i=0; int j=s.length()-1;
		while(i<j) {
            if(isNotVowel(ar[i])){
                i++;
            }else if(isNotVowel(ar[j])){
                j--;
            }else{
				char temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				i++;
				j--;
            }
		}
		return new String(ar);
	}
    
    boolean isNotVowel(char ch) {
		return !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U');			
	}
        
}