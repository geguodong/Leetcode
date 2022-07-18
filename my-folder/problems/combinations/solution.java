// backtracking
// O(k C k, n)
// O(C k, n)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<Integer>();
        backtrack(n, 1, res, cur, k);
       
        return res;
    }
    
    private void backtrack(int n, int index, List<List<Integer>> res, LinkedList<Integer> cur, int k) {

        if(cur.size() == k) {
            res.add(new LinkedList<>(cur));
            return;
        }
        
        for(int i = index; i <= n; i++) {
            cur.add(i);
            backtrack(n, i + 1, res, cur, k);
            cur.removeLast();
        }    

    }
}