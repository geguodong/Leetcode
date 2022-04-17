class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        
        for(int i = nums.length - 1; i > 0; i -= 2) {
            sum += nums[i - 1];
        }
        return sum;
    }
}