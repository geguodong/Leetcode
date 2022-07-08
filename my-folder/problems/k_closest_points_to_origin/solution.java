// O(nlogn) O(1) -- O(logN) to O(N)O(N) for the extra space required by the sorting process.
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][];
        if(points == null || points.length == 0) {
            return res;
        }
        
        Arrays.sort(points, (a, b) -> { return a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1];});
        
        for(int i = 0; i < k && i < points.length; i++) {
            res[i] = points[i];
        }
        return res;
    }
}