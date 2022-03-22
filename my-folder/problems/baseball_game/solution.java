class Solution {
    public int calPoints(String[] ops) {
        int[] scores = new int[ops.length];
        int index = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("D")) {
                scores[index] = 2 * scores[index - 1];
                index++;
            } else if (ops[i].equals("+")) {
                scores[index] = scores[index - 1] + scores[index - 2];
                index++;
            } else if (ops[i].equals("C")) {
                scores[index - 1] = 0;
                index--;
            } else {
                scores[index] = Integer.valueOf(ops[i]);
                index++;
            }
        } 
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += scores[i];
        }
        return sum;
    }
}