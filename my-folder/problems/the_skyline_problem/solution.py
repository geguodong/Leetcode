import heapq
import collections

class Solution:
    def getSkyline(self, buildings):
        treeMap = collections.defaultdict(list)
        for b in buildings:
            treeMap[b[0]].append(b)
            treeMap[b[1]].append(b)

        keys = sorted(treeMap.keys())

        skyline = []
        maxHeap = []

        for key in keys:
            for start, end, height in treeMap[key]:
                if key == start:
                    heapq.heappush(maxHeap, (-height, start, end))

            while maxHeap and key >= maxHeap[0][2]:
                heapq.heappop(maxHeap)

            curMaxHeight = -maxHeap[0][0] if maxHeap else 0

            if not skyline or curMaxHeight != skyline[-1][1]:
                skyline.append([key, curMaxHeight])

        return skyline