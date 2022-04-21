class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[501];

        if (n % 2 != 0) {
            return false;
        }

        // counting occurrence
        for (int num : nums) {
            count[num]++;
        }

        for (int i : count) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}