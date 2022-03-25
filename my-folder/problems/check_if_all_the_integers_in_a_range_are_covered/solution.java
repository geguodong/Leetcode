class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[52];
        for (int[] range : ranges) {
            arr[range[0]] += 1;
            arr[range[1] + 1] -= 1;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            if (i >= left && i <= right && arr[i] <= 0) {
                return false;
            }
        }
        return true;
    }
}