class Solution {
    public boolean makeEqual(String[] words) {
        if (words.length <= 1) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            for (int j = 0; j < word.length(); j++) {
                map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);
            }
        }
                        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % words.length != 0) {
                return false;
            }
        }
        
        return true;
    }
}