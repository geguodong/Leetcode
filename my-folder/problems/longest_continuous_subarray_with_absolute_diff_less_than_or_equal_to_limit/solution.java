// Sliding window
// Two Deque to maintain miValue and maxVaue

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> increasing = new LinkedList<>(); // Min-Value;
        Deque<Integer> decreasing = new LinkedList<>(); // Max-Value;
        int left = 0;
        int right =0;
        int maxLength = 0;
        
        int n = nums.length;
        
        while(right < n) {
            // maintain minValue
            while(increasing.size() != 0 && nums[increasing.peekLast()] >= nums[right]) {
                increasing.pollLast();
            }
            increasing.add(right);
            // maintain maxValue
            while(decreasing.size() != 0 && nums[decreasing.peekLast()] <= nums[right]) {
                decreasing.pollLast();
            }
            decreasing.add(right);
            
            int maxValue = nums[decreasing.peekFirst()];
            int minValue = nums[increasing.peekFirst()];
            
            if(left <= right && maxValue - minValue <= limit) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while(left <= right && nums[decreasing.peekFirst()] - nums[increasing.peekFirst()] > limit) {
                    if(!increasing.isEmpty() && increasing.peekFirst() == left){
                        increasing.pollFirst() ;
                    }
                
                    if(!decreasing.isEmpty() && decreasing.peekFirst() == left){
                        decreasing.pollFirst() ;
                    }
                
                    left++ ; 
                }
            }
            right++;
            
        }
        return maxLength;
    }
}