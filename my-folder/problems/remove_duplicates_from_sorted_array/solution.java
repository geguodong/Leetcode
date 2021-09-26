// O(N) O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        int last = 0;;
        for (int i = 1; i < nums.length; i++) {
            if (nums[last] != nums[i]) {
                last++;
                nums[last] = nums[i];
                res++;
            }
        }
        return res;
    }
}