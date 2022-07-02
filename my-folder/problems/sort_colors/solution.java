class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, cur = 0;
        int p2 = nums.length - 1;
        int temp;
        while(cur <= p2) {
            if(nums[cur] == 0) {
                temp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = temp;
            } else if (nums[cur] == 2) {
                temp = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = temp; 
            } else {
                cur++;
            }
        }
    }
}