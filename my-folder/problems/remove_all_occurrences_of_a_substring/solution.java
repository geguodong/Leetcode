
class Solution {
    public String removeOccurrences(String s, String part) {
        if(s.length() < part.length())  return s;
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            sb.append(ch);
            
            if(sb.length() < part.length()){
                continue;
            }
            int endExclusive = sb.length();
            int startInclusive = sb.length() - part.length();
            
            String substring = sb.substring(startInclusive, endExclusive);
            
            if(substring.equals(part)){
                sb.delete(startInclusive, endExclusive);
            }
        }
        
        return sb.toString();
    }
}