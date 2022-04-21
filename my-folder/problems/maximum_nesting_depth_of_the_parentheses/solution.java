class Solution {
    public int maxDepth(String s) {
        int depth=0;
        Stack<Character> par= new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                par.push(ch);
            }
            else if(ch==')'){
                depth= Math.max(depth, par.size());
                par.pop();
            }
        }
        return depth;
    }
}