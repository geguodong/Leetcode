/*
Two Pointer
Time complexity: O(n)O(n). Single iteration of O(n)O(n).
Space complexity: O(1)O(1) extra space. Only constant space required for \text{left}left, \text{right}right, \text{left\_max}left_max and \text{right\_max}right_max.
*/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            }
            else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                } 
                --right;
            }
        }
        return ans; 
    }
}