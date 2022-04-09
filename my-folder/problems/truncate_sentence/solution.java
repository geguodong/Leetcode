class Solution {
    public String truncateSentence(String s, int k) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
            }
            
            if (k == 0) {
                return s.substring(0, i);
            }
        }

        return s;
    }
}