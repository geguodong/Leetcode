class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = 0, second = 0, target = 0;
        for (char c : firstWord.toCharArray()) {
            first = 10 * first + (c - 'a');
        }
        for (char c : secondWord.toCharArray()) {
            second = 10 * second + (c - 'a');
        }
        for (char c : targetWord.toCharArray()) {
            target = 10 * target + (c - 'a');
        }
        return target == first + second;
    }
}