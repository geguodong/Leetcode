class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(candidates, 0, target, path, res);
        return res;
    }
    
    private void backtrack(int[] candidates, int start, int remain, LinkedList<Integer> path, List<List<Integer>> res) {
        if(remain == 0) {
            res.add(new LinkedList<>(path));
        }
        
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > remain) {
                continue;
            }
            
            path.add(candidates[i]);
            backtrack(candidates, i, remain - candidates[i], path, res);
            path.removeLast();
        }
    }
}