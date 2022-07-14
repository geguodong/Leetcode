// DP only keep 2
// O(N) O(1)
class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 0) {
            return 0;
        }
        
        int robNext, robNextPlusOne;
        robNextPlusOne = 0;
        robNext = nums[N - 1];
        
        for(int i = N - 2; i >= 0; i--) {
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }
}