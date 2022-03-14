/*
Note : when equals to 1, update max, care about last num is 1, if when equals to 0
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
                max = Math.max(max, cur);
            } else {   
                cur = 0;
            }
        }
        return max;
    }
}