/*
Using Hash Map
Time complexity: O(n). Where nn is the length of the array. This is because we must insert every number into the hash map and insertion into a hash map is a constant time operation.
Space complexity: O(n). In the worst case we will need to store all of the numbers with a frequency of 1.
*/
class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        // Store counts of each element
        for (int i : A) {
          count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // If count of the integer is 1 get maximum.
            if (entry.getValue() == 1) {
              result = Math.max(result, entry.getKey());
            }
        }
        return result;
    }
}