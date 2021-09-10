// O(n)  O(1)
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}