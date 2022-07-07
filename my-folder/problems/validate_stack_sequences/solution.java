// Greddy O(n) O(n)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = popped.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int x : pushed) {
            stack.push(x);
            while(!stack.isEmpty() && j < N && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }
}