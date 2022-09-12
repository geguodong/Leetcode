class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = sorted.length - 1; i >= 0; i--) {
            index.put(sorted[i], i);
        }
        
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = index.get(nums[i]);
        }
        return res;
    }
}