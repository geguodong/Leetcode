class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        for(int i = 0; i <= nums.length; i++) {
            backtrack(nums, 0, i, cur, res);
        }
        
        return res;
    }
    
    private void backtrack(int[] nums, int index, int length, LinkedList<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == length) {
            res.add(new LinkedList<>(cur));
            return;
        }
        
        for(int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, length, cur, res);
            cur.remove(cur.size() - 1);
        }
       
    }
}