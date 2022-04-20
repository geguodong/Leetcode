class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0, max = 0;
        for (int height : gain) {
            sum += height;
            max = Math.max(sum, max);
        }
        return max;
    }
}