class Solution {
    public String countAndSay(int n) {  
		return n==1 ? "1" : createString(countAndSay(n - 1));   
    }
    private String createString(String s) {
        int c = 1;  StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {  
				c++; 
			} else {  
				sb.append(c).append(s.charAt(i));
				c=1; 
			}
        }
        return sb.append(c).append(s.charAt(s.length()-1)).toString();
    }
}