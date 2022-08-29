// O(N) O(1)
class Solution {
    public int minSteps(String s, String t) {
        int[] countS = new int[26];
        for(char c : s.toCharArray()) {
            countS[c - 'a']++;
        }
        int[] countT = new int[26];
        for(char c : t.toCharArray()) {
            countT[c - 'a']++;
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            if(countS[i] - countT[i] > 0) {
                res += countS[i] - countT[i];
            }
        }
        return res;
    }
}