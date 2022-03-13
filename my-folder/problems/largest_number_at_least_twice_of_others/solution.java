class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int first = 0;
        int second = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= first) {
                second = first;
                first = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (first >= 2*second) {
            return index;
        } else {
            return -1;
        }
    }
}