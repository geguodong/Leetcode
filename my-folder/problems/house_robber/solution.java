/*
Time Complexity: O(N) since we process at most NN recursive calls, thanks to caching, and during each of these calls, we make an O(1) computation which is simply making two other recursive calls, finding their maximum, and populating the cache based on that.

Space Complexity: O(N) which is occupied by the cache and also by the recursion stack.
*/

class Solution {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        
        this.memo = new int[100];
        
        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);
        
        return this.robFrom(0, nums);
    }
    
    private int robFrom(int i, int[] nums) {
        
        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }
        
        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }
        
        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
        
        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }
}