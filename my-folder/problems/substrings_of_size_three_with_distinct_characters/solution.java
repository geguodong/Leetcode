class Solution {
    public int countGoodSubstrings(String s) {
        var map = new HashMap<Character, Integer>();
        int distinctSubString = 0;
        int windowStart = 0;
        int windowEnd = 0;
        while (windowEnd < s.length()) {
            char c = s.charAt(windowEnd);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (windowEnd - windowStart + 1 == 3) {
                if (map.size() == 3) distinctSubString++;
                char cs = s.charAt(windowStart);
                if (map.get(cs) == 1) {
                    map.remove(cs);
                } else {
                    map.put(cs, map.get(cs) - 1);
                }

                windowStart++;
            }
            windowEnd++;
        }

        return distinctSubString;
    }
}
