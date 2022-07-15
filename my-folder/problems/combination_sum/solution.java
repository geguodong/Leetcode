// BackTracking
// Let N be the number of candidates, T  be the target value, and M be the minimal value among the candidates.
// Time Complexity: O(N^ T/M+1)
// Space Complexity: O(N^ T/M)   
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(candidates, 0, target, res, cur);
        return res;
    }
    
    private void helper(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> cur) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur));
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            cur.add(candidates[i]);
            helper(candidates, i, target - candidates[i], res, cur);
            // backtrack, remove the number from the combination
            cur.remove(cur.size() - 1);
        }
        
    }
}