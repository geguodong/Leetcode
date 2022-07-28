class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if(candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0,  res, path, 0, target);
        return res;
    }
    
    private void backtrack(int[] candidates, int start, List<List<Integer>> res, LinkedList<Integer> path, int curSum, int target) {
        if(curSum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        
        if(curSum > target) {
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            curSum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, i, res, path, curSum, target);
            curSum -= candidates[i];
            path.removeLast();
        }
    } 
    
}