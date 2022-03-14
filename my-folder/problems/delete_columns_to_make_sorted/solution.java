class Solution {
    public int minDeletionSize(String[] a) {
        int deleteCount = 0;
        int strCount = a[0].length();
        for (int i = 0; i < strCount; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j].charAt(i) < a[j - 1].charAt(i)) {
                    deleteCount++;
                    break;
                }
            }
        }
        return deleteCount;
    }
}