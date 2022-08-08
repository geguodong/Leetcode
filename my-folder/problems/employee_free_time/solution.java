/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Entry {
    int row;
    int col;
    Interval interval;
    public Entry(Interval interval, int row, int col) {
        this.row = row;
        this.col = col;
        this.interval = interval;
    }
}

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        if(schedule == null || schedule.size() == 0) {
            return res;
        }
        int left = Integer.MIN_VALUE;
        PriorityQueue<Entry> heap = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);
        
        for(int i = 0; i < schedule.size(); i++) {
            heap.add(new Entry(schedule.get(i).get(0), i, 0));
        }
        
        while(heap.size() != 0) {
            Entry cur = heap.poll();
            int row = cur.row;
            int col = cur.col;
            if(left != Integer.MIN_VALUE && left < cur.interval.start) {
                res.add(new Interval(left, cur.interval.start));
            } 
            left = Math.max(left, cur.interval.end);
            
            if(col < schedule.get(row).size() - 1) {
                heap.add(new Entry(schedule.get(row).get(col + 1), row, col + 1));
            }
        }
        return res;
        
    }
}