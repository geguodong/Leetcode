class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        for(char c : chars) {
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}