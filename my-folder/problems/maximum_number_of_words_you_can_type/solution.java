class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (Character c : brokenLetters.toCharArray()) {
            broken.add(c);
        }
        
        int res = 0;
        for (String word : text.split(" ")) {
            res++;
            for (Character c : word.toCharArray()) {
                if (broken.contains(c)) {
                    res--;
                    break;
                }
            }
            
        }
        return res;
    }
}