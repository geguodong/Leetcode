// BackTracking
// O(N * 2^N) O(N)
class Solution {
  List<List<Integer>> output = new ArrayList();
  int n;

  public void backtrack(int first, ArrayList<Integer> curr, int[] nums, int k) {
    // if the combination is done
    if (curr.size() == k) {
      output.add(new ArrayList(curr));
      return;
    }
    for (int i = first; i < n; ++i) {
      // add i into the current combination
      curr.add(nums[i]);
      // use next integers to complete the combination
      backtrack(i + 1, curr, nums, k);
      // backtrack
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    n = nums.length;
    for (int k = 0; k < n + 1; ++k) {
      backtrack(0, new ArrayList<Integer>(), nums, k);
    }
    return output;
  }
}