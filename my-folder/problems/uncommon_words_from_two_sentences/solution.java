/*
Time Complexity: O(M + N), where M, NM,N are the lengths of A and B respectively.
Space Complexity: O(M + N)
*/
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : s1.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        for (String word : s2.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        List<String> res = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}