class Solution {
    public int[] buildArray(int[] nums) {
        int k = 0;
        while (k < nums.length) {
            if (nums[k] > 0) {
                int first = nums[k];
                int j = k;
                while (nums[j] != k && nums[j] >= 0) {
                    int temp = nums[j];
                    nums[j] = -nums[temp];
                    j = temp;
                }
                nums[j] = - first;
            }
            k++;
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        
        return nums;
    }
}