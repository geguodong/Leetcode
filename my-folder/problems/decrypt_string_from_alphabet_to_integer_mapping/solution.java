class Solution {
    public String freqAlphabets(String s) {
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i<s.length())
        {
            if(i+2<s.length() && s.charAt(i+2)=='#')
            {
                int num = Integer.parseInt(s.substring(i,i+2));
                sb.append((char)(96+num));
                i=i+3;
            }
            else
            {
                sb.append((char)(96+(s.charAt(i)-'0')));
                i=i+1;
            }
        }
        return sb.toString();
    }
}