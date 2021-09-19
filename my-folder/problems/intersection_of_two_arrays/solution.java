// O(n)
// O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        for (int num : nums1) {
            nums.add(num);
        }
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums2) {
            if (nums.contains(num) && !uniqueNums.contains(num)) {
                uniqueNums.add(num);
            }
        }
        int res[] = new int[uniqueNums.size()];
        int i = 0;
        for (int num : uniqueNums) {
            res[i] = num;
            i++;
        }
        return res;
    }
}