class Solution {
    public boolean checkZeroOnes(String s) {
        int count0 = 0, count1 = 0;
        int temp0 = 0, temp1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                temp1 = 0;
                temp0++;
                count0 = Math.max(count0, temp0);
            } else if (c == '1') {
                temp0 = 0;
                temp1++;
                count1 = Math.max(count1, temp1);
            }
        }
        return count1 > count0;
    }
}