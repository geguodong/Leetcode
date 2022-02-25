/*

HASH TABLE

Time complexity : O(n). We do nn operations of search, delete and insert, each with constant time complexity.

Space complexity : O(min(n,k)). The extra space required depends on the number of items stored in the hash table, which is the size of the sliding window, min(n,k).
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}