class Solution {
    public int balancedStringSplit(String s) {
        int count = 0, balanced = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'R') {
                balanced++;
            } else {
                balanced--;
            }
            if (balanced == 0) {
                count++;
            }
        }
        return count;
    }
}