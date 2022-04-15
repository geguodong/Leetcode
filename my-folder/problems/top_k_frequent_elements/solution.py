import heapq
import collections

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = collections.defaultdict(int)
        for num in nums:
            counter[num] += 1
            
        minHeap = []
        
        for key, val in counter.items():
            heapq.heappush(minHeap, (val, key))
            while len(minHeap) > k:
                heapq.heappop(minHeap)
                
        return [key for _, key in minHeap]