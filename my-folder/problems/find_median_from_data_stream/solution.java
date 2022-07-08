class MedianFinder {
    
    // maxHeap
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> bigger;
    public MedianFinder() {
        smaller = new PriorityQueue<>((a, b) -> b - a);
        bigger = new PriorityQueue<>(); // by default minHeap;
    }
    
    public void addNum(int num) {
        if(smaller.size() == 0 || num > smaller.peek()) {
            bigger.add(num);
            if(bigger.size() > smaller.size() + 1) {
                smaller.add(bigger.remove());
            }
        } else {
            smaller.add(num);
            if(smaller.size() > bigger.size() + 1) {
                bigger.add(smaller.remove());
            }
        }
      
        
    }
    
    public double findMedian() {
        if(smaller.size() == bigger.size()) {
            return (double)(smaller.peek() + bigger.peek()) / 2;
        } else if (smaller.size() > bigger.size()) {
            return smaller.peek();
        } else {
            return bigger.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */