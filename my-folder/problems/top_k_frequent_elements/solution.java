class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length <= k) {
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for(int n : count.keySet()) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] topK = new int[heap.size()];
        for(int i = heap.size() - 1; i >= 0; i--) {
            topK[i] = heap.poll();
        }
        return topK;
    }
}