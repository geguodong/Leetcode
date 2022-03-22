class Solution {     
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray(); 
        
        for (int i = 0; i < s.length(); i++) {
            
            switch(c[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default: 
                    sb.append(c[i]);
            }
                  
        }
        
        return sb.toString();
    }
        
}