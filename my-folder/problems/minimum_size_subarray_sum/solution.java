class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        int start = 0;
        int end = 0;
        while(end < nums.length && start < nums.length) {
            curSum += nums[end];
            while(curSum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                curSum -= nums[start];
                start++;  
            } 
            end++;
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }
}