/*
O(n) 
O(1)
*/
class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
                late = 0;
            } else if (c == 'L') {
                late++;
            } else {
                late = 0;
            }
            if (absent >= 2 || late >= 3) {
                return false;
            }
        }
        return true;
    }
}