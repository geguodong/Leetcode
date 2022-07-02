/*
Given NN as the length of nums and MM as the number of calls to add(),

Time complexity: O(N⋅log(N)+M⋅log(k))

The time complexity is split into two parts. First, the constructor needs to turn nums into a heap of size k. In Python, heapq.heapify() can turn nums into a heap in O(N)O(N) time. Then, we need to remove from the heap until there are only k elements in it, which means removing N - k elements. Since k can be, say 1, in terms of big OO this is N operations, with each operation costing \log(N)log(N). Therefore, the constructor costs O(N + N \cdot \log(N)) = O(N \cdot \log(N))O(N+N⋅log(N))=O(N⋅log(N)).

Next, every call to add() involves adding an element to heap and potentially removing an element from heap. Since our heap is of size k, every call to add() at worst costs O(2 * \log(k)) = O(\log(k))O(2∗log(k))=O(log(k)). That means M calls to add() costs O(M \cdot \log(k))O(M⋅log(k)).

Space complexity: O(N)

The only extra space we use is the heap. While during add() calls we limit the size of the heap to k, in the constructor we start by converting nums into a heap, which means the heap will initially be of size N.



*/
class KthLargest {
    private static int k;
    private PriorityQueue<Integer> heap;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        
        for (int num: nums) {
            heap.offer(num);
        }
        
        while (heap.size() > k) {
            heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */