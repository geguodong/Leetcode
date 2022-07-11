// Stack
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            
            // Be careful !!!
            int num2 = stack.pop();
            int num1 = stack.pop();
            int res = 0;
            switch(token) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;           
            }
            System.out.println(res);
            stack.push(res);
        }
        return stack.pop();
    }
}