class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // to make sure the last word be counted 
        paragraph += '.';
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String ans = "";
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                sb = new StringBuilder();
                if (!bannedSet.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) > count) {
                    count = map.get(word);
                    ans = word;
                    }           
                }       
            }
        }
        return ans;
    }
}
