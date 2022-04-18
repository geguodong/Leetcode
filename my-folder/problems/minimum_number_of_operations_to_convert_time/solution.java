// Greedy Solution
// Time complexity: O(1), O(T) where T is a constant
// Space complexity: O(1)
class Solution {
    private static final int[] TIMES = {60, 15, 5, 1};
    
    public int convertTime(String current, String correct) {
        int t1 = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
        int t2 = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));
        int ops = 0;
        for (int time : TIMES) {
            while (t1 + time <= t2) {
                t1 += time;
                ops++;
            }
        }
        return ops;
    }
}