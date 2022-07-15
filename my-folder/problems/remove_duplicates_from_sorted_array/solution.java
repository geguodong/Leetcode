// O(N) O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int last = 0;;
        for (int i = 1; i < nums.length; i++) {
            if (nums[last] != nums[i]) {
                last++;
                nums[last] = nums[i];
           //     res++;
            }
        }
       // return res;
        return last + 1; // index + 1  == num
    }
}