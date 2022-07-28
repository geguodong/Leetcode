class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        backtrack(nums, 0, res, current);
        return res;
    }
    
    private void backtrack(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> cur) {
        res.add(new LinkedList(cur));
        
        for(int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, res, cur);
            cur.removeLast();
        }
    }
    
}