class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(last != -1 && i - last <= k) {
                    return false;
                } 
                last = i;
            }
        }
        return true;
    }
}