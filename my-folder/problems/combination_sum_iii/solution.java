// backTracking
// Time Complexity: O(9!⋅K/ (9−K)!)
// O(K)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        helper(k, n, 1, res, cur);
        return res;
    }
    
    private void helper(int k, int target, int start, List<List<Integer>> res, LinkedList<Integer> cur) {
        if(k < 0 || target < 0) {
            return;
        }
        if(k == 0 && target == 0) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            cur.add(i);
            helper(k - 1, target - i, i + 1, res, cur);
            cur.removeLast();
        }
    }
}