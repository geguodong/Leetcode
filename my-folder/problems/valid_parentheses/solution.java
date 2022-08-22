class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(c == '}') {
                if(stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
                 
            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
                 
            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }    
            } else {
                stack.push(c);
            }
            
        }
        return stack.isEmpty();
    }
}