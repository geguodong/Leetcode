/*
Time complexity : \mathcal{O}(1)O(1).
Space complexity : \mathcal{O}(1)O(1).
*/

class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n == 0) return false;
    long x = (long) n;
    return (x & (-x)) == x;
  }
}