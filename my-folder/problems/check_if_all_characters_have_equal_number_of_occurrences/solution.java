class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] charValuesCount = new int[26];
        Arrays.fill(charValuesCount, -1);
        for (int i = 0; i < s.length(); i++) {
            charValuesCount[s.charAt(i) - 'a'] += 1;
        }
        int countToCompare = -1;
        for (int val : charValuesCount) {
            if (val != -1) {
                countToCompare = val;
                break;
            }
        }
        for (int val : charValuesCount) {
            if (val != -1 && val != countToCompare) {
                return false;
            }
        }
        return true;
    }
}