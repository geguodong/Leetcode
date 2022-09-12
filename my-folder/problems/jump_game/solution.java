class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        
        int cur = 0; 
        int farthest = nums[0];
        for(int i = 0; i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}