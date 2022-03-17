class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = 0;
        int min = nums[0];
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        if (min >= 0) {
            return 1;
        } else {
            return -1 * min + 1;
        }
    }
}