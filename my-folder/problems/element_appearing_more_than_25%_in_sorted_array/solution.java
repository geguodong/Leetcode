class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] == arr[i - 1]) {
                count++;
                if (count > arr.length / 4) {
                    return arr[i];
                }
            } else {
                count = 1;
            }
        }
        return -1;
    }
}