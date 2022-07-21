// O(n) O(n)
public class Solution {
    public int numSplits(String s) {
        if(s == null || s.length() < 2) {
            return 0;
        }
        
        // add char to map
        Map<Character, Integer> rightMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            rightMap.put(c, rightMap.getOrDefault(c, 0) + 1);
        }
        
        int count = 0; 
        // traverse
        Map<Character, Integer> leftMap = new HashMap<>();
        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            leftMap.put(c, leftMap.getOrDefault(c, 0) + 1);
            rightMap.put(c, rightMap.get(c) - 1);
            if(rightMap.get(c) == 0) {
                rightMap.remove(c);
            }
            if(leftMap.size() == rightMap.size()) {
                count++;
            }
        }
        return count;
    }
    
}