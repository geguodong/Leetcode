class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int s: salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            total += s;
        }
        total -= (min + max);
        return total * 1.0 / (salary.length - 2);
    }
}