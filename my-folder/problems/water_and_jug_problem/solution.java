class Solution {
    public boolean canMeasureWater(int m, int n, int t) {
        if(m + n < t) {
            return false;
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        int cur = 0;
        while(!queue.isEmpty()) {
            int top = queue.poll();
            if(top == t) {
                return true;
            }
            if(top + m <= m + n && !visited.contains(top + m)) {
                queue.add(top + m);
                visited.add(top + m);
            }
            if(top - m >= 0 && !visited.contains(top - m)) {
                queue.add(top - m);
                visited.add(top - m);
            }
            if(top + n <= m + n && !visited.contains(top + n)) {
                queue.add(top + n);
                visited.add(top + n);
            }
            if(top - n >= 0  && !visited.contains(top - n)) {
                queue.add(top - n);
                visited.add(top - n);
            }
        }
        return false;
    }
}