class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        var start = 0;
        for (var i = 0; i + k - 1 < nums.length; i++)
            if (nums[i] > nums[start])
                start = i;

        return Arrays.copyOfRange(nums, start, start + k);
    }
}