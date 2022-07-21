// Heap + HeashMap
// O(nlogn) O(n)
class Solution {
     public List<String> topKFrequent(String[] words, int k) {
        // map word to its frequency
        Map<String, Integer> map = new HashMap<>(); 
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // min-heap
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                if(map.get(a) != map.get(b)) { // different frequency
                    return map.get(a) - map.get(b); // minHeap
                } else { // same frequency
                    return b.compareTo(a);  
                }
            }
        });
        
        for(String s: map.keySet()) {
           // pq.offer(s);
            pq.add(s);
            if(pq.size() > k) pq.poll();
        }
        
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            list.add(0, pq.poll());
        }
        
        return list;
    }
}