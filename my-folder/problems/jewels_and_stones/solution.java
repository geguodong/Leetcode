// O(M + N)
// O(M)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        if(jewels == null || jewels.length() == 0 || stones == null || stones.length() == 0) {
            return 0;
        }
        Set<Character> jewel = new HashSet<>();
        for(char c : jewels.toCharArray()) {
            jewel.add(c);
        }
        
        int res = 0;
        for(char c : stones.toCharArray()) {
            if(jewel.contains(c)) {
                res++;
            }
        }
        return res;
    }
}