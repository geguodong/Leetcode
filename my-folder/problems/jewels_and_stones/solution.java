class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (Character c : jewels.toCharArray()) {
            if (map.containsKey(c) ) {
                res += map.get(c);
            }
        }
        return res;
    }
}