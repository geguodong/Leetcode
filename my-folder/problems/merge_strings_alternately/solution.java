// Two Pointer
// O(n) O(1)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int first = 0, second = 0;
        StringBuilder sb = new StringBuilder();
        while (first < word1.length() && second < word2.length()) {
            sb.append(word1.charAt(first));
            sb.append(word2.charAt(second));
            first++;
            second++;
        }
        if (first < word1.length()) {
            sb.append(word1.substring(first));
        }
        if (second < word2.length()) {
            sb.append(word2.substring(second));
        }
        return sb.toString();
    }
}