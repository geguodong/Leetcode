/*
Actually, we only need to check the substring with the minSize, since the occurences of substrings with longer length must be less than or equal to the ones with shorter length.


*/

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> occurrences = new HashMap<>();
        // Count ocurrences per letter inside window
        int[] countLetters = new int[26];
        // Count total amount of unique letters inside window
        int countUnique = 0;
        int left = 0;
        int right = 0;
        
        while (right < s.length()){
            // Add new character to the window
            char r = s.charAt(right++);
            countLetters[r - 'a']++;
            
            // If it's the first time we see this character increase unique
            if (countLetters[r - 'a'] == 1) {
                countUnique++;
            }

            while ((right - left) >= minSize) {
                if (countUnique <= maxLetters) {
                    String subs = s.substring(left, right);
                    occurrences.put(subs, occurrences.getOrDefault(subs, 0) + 1);
                }
                
                char l = s.charAt(left++);
                countLetters[l - 'a']--;
                
                // Unique character left the window
                if (countLetters[l - 'a'] == 0) {
                    countUnique--;
                }
            }
        }
        return occurrences.size() == 0? 0 : Collections.max(occurrences.values());
        
    }
}