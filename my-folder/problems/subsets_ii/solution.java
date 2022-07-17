// BackTracking
// O(N * 2^ N)
// O(N)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        Arrays.sort(nums);
        helper(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, int start, LinkedList<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        
        for(int i = start; i < nums.length; i++) {
            if(i != start && nums[i] == nums[i - 1]) {
                continue;
            }       
            cur.add(nums[i]);
            helper(nums, i + 1, cur, res);
            cur.removeLast();
        }

    }
}