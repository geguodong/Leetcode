class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for(String s : words1) {
            map1.put(s,map1.getOrDefault(s, 0) + 1);
        }
        
        for(String s : words2) {
            map2.put(s,map2.getOrDefault(s, 0) + 1);
        }
        
        int count = 0;
        for(Map.Entry<String,Integer> e: map1.entrySet()) {
            if(map2.containsKey(e.getKey()) && e.getValue()==1 && map2.get(e.getKey())==1)
                count++;
        }
        
        return count;
    }
}