// Two pointer
// O(n^2)
// O(1) --> O(logn) to O(n), depending on the implementation of the sorting algorithm.
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length && diff != 0; i++) {
            int low = i + 1; 
            int high = nums.length - 1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if(sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return target - diff;
    }
}