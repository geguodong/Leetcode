class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if(candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curSum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, i + 1, res, path, curSum, target);
            curSum -= candidates[i];
            path.removeLast();
        }
    }     
}
