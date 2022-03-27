class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        // max sum can be obtained by adding the largest elements in the array
        // sort the array and start from the largest element and check if it is greater than the sum of rest
        // if yes, that is your ans. if not, add the second largest element and check and keep going until you find your solution
        
        if(nums.length == 1) return Arrays.asList(nums[0]);
        
        Arrays.sort(nums);
        
        int sum = 0;
        for(int num : nums) sum += num;
        
        List<Integer> list = new ArrayList<>();
        int previousSum = 0;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] + previousSum > sum-nums[i]-previousSum) {
                list.add(nums[i]);
                break;
            } else {
                list.add(nums[i]);
                previousSum += nums[i];
            }
        }
        
        return list;
        
    }
}