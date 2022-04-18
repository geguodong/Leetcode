class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        while(k-->0){
            Arrays.sort(nums);
            nums[0] = 0 - nums[0];
        }
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }
}