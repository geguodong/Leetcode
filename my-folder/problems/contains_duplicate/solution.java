/*
Time complexity : O(n). We do search() and insert() for nn times and each operation takes constant time.
Space complexity : O(n). The space used by a hash table is linear with the number of elements in it.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}