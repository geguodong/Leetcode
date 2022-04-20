class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        int[] point1 = points[0];
        for(int i=1;i<points.length;i++) {
            int[] point2 = points[i];
            int diffx = point2[0] - point1[0];
            int diffy = point2[1] - point1[1];
            count += Math.max(Math.abs(diffx), Math.abs(diffy));
            point1 = point2;
        }
        return count;
    }
}