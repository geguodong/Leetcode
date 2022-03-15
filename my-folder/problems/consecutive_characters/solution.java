class Solution {
    public int maxPower(String s) {
        int max = 1;
        int temp = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }
        return max;
    }
}