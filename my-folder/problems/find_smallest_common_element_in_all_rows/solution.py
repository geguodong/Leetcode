import heapq

class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        minHeap = []
        counter = {}
        
        m = len(mat)
        n = len(mat[0])
        
        for i, row in enumerate(mat):
            heapq.heappush(minHeap, (row[0], i, 0))
            if row[0] in counter:
                counter[row[0]] += 1
            else:
                counter[row[0]] = 1
                
        while len(minHeap) == m:
            if len(counter) == 1:
                return minHeap[0][0]
            
            val, i, j = heapq.heappop(minHeap)
            counter[val] -= 1
            if counter[val] == 0:
                counter.pop(val)
                
            if j < n - 1:
                heapq.heappush(minHeap, (mat[i][j + 1], i, j + 1))
                if mat[i][j + 1] in counter:
                    counter[mat[i][j + 1]] += 1
                else:
                    counter[mat[i][j + 1]] = 1
            
        return -1
            