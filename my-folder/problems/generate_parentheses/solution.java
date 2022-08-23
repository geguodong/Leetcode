class Solution {
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, new StringBuilder());
        return res;
    }
    
    private void generateParenthesis(int open, int close, StringBuilder sb) {
        if(open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }
        if(open > 0) {
            sb.append("(");
            
            generateParenthesis(open - 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close > open) {
            sb.append(")");
            generateParenthesis(open, close - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}