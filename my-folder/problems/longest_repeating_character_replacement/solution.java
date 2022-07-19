// O(N) O(1)
class Solution {
    public int characterReplacement(String s, int k) {

        int longestSubstring = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxRepeatingCharCount = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            maxRepeatingCharCount = Math.max(maxRepeatingCharCount, map.get(c));
            if (end - start + 1 - maxRepeatingCharCount > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start += 1;
            }

            longestSubstring = Math.max(longestSubstring, end - start + 1);
            end += 1;
        }
        return longestSubstring;
    }
}