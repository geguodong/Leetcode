class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int apples = 0, units = 0;
        for (int i = 0; i < arr.length && units + arr[i] <= 5000; i++) {
            apples++;
            units += arr[i];
        }
        return apples;
    }
}