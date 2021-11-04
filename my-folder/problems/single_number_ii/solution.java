/*
HashMap
Time complexity : O(N) to iterate over the input array.
Space complexity : O(N) to keep the set of N/3 elements.
*/
class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> hashmap = new HashMap<>();
    for (int num : nums)
      hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

    for (int k : hashmap.keySet())
      if (hashmap.get(k) == 1) return k;
    return -1;
  }
}