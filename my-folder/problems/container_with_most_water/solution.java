/*
Two pointer

Note : different with another problem ~ 8--8 + 8 ~ 7
Time complexity : O(n). Single pass.
Space complexity : O(1). Constant space is used.
*/

public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}