
class Solution {
    private List<String> all = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", n, n);
        return all;
    }

    private void backtrack(String now, int l, int r){
        if(l+r==0){
            all.add(now);
            return;
        }
        if(l>0) backtrack(now+'(', l-1, r);
        if(l<r) backtrack(now+')', l, r-1);
    }
}
