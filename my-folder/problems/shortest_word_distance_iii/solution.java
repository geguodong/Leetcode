// Two pointers
// O(N)
// O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        int lastIndex = -1;
        for(int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if(word1.equals(word) && word2.equals(word)) {
                if(lastIndex != -1) {
                    res = Math.min(res, i - lastIndex);
                }
                lastIndex = i;
            } else if(word1.equals(word)) {
                p1 = i;
            } else if(word2.equals(word)) {
                p2 = i;
            }
            
            if(p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}