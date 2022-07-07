// Greddy with Stack
// O(N) O(N)
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.add(c);
        }
        
        // for remaining k
        while(k > 0 && stack.size() > 0) {
            k--;
            stack.pop();
        }
        
        // remove leading zeros
        boolean leadZero = true;
        StringBuilder sb = new StringBuilder();
        List<Character> list = new LinkedList<>();
        while(stack.size() > 0) {
            list.add(0, stack.pop());
        }
        for(char c : list) {
            if(leadZero && c == '0') continue;
            leadZero = false;
            sb.append(c);
        }
        
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}