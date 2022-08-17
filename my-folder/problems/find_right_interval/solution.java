public class Solution {

  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, Integer> starts = new TreeMap<>();
    int res[] = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts.put(intervals[i][0], i);
    }
    for (int i = 0; i < intervals.length; i++) {
      Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i][1]);
      res[i] = pos == null ? -1 : pos.getValue();
    }
    return res;
  }
}