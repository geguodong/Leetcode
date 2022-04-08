class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
                if (count > nums.length / 2) {
                    return true;
                }
            }
        } 
        return false;
    }
}