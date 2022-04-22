class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();
        for(char letter: word1.toCharArray()) {
            freqMap1.put(letter, freqMap1.getOrDefault(letter, 0) + 1);
        }
        for(char letter: word2.toCharArray()) {
            freqMap2.put(letter, freqMap2.getOrDefault(letter, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: freqMap1.entrySet()) {
            if(Math.abs(freqMap2.getOrDefault(entry.getKey(), 0)-entry.getValue()) > 3) {
                return false;
            }
        }
        for(Map.Entry<Character, Integer> entry: freqMap2.entrySet()) {
            if(Math.abs(freqMap1.getOrDefault(entry.getKey(), 0)-entry.getValue()) > 3) {
                return false;
            }
        }
        return true;
    }
}