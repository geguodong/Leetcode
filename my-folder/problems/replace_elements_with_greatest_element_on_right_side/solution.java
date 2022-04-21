class Solution {
    public int[] replaceElements(int[] arr) {
        int previousHigh = arr[arr.length - 1];
        arr[arr.length - 1] =  -1;
        
        for (int i = arr.length - 2; i >= 0; i--) {
            int cur = arr[i];
            arr[i] = previousHigh;
            if (cur > previousHigh) previousHigh = cur;
        }
        return arr;
    }
}