import collections

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        target = '123450'
        
        start = ''.join(map(str, board[0] + board[1]))
        moves = 0
        visited = {start}
        queue = collections.deque([start])
        
        while queue:
            for _ in range(len(queue)):
                cur = queue.popleft()
                if cur == target:
                    return moves
                
                for nextState in self.findNextStates(cur):
                    if nextState not in visited:
                        queue.append(nextState)
                        visited.add(nextState)
                
            moves += 1
            
        return -1
                
    def findNextStates(self, cur):
        directions = [
            [1, 3],
            [0, 2, 4],
            [1, 5],
            [0, 4],
            [1, 3, 5],
            [2, 4]
        ]
        
        idx0 = cur.find('0')
        nextStates = []
        
        for newIdx in directions[idx0]:
            curList = list(cur)
            curList[idx0], curList[newIdx] = curList[newIdx], curList[idx0]
            nextStates.append(''.join(curList))
            
        return nextStates