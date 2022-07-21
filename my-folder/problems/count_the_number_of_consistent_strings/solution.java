class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allow = new HashSet<>();
        for (Character c : allowed.toCharArray()) {
            allow.add(c);
        }
        int num = 0;
        for (String word : words) {
            num++;
            for (Character c : word.toCharArray()) {
                if (!allow.contains(c)) {
                    num--;
                    break;
                }
            }
        }
    return num;
    }
}
