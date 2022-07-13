class Solution:
    def constructDistancedSequence(self, n: int) -> List[int]:
        res = [0] * (2 * n - 1)
        self.dfs(res, n, 0, set())
        return res
    
    def dfs(self, res, n, idx, seen):
        if len(res) == idx:
            return True
        
        if res[idx] > 0:
            return self.dfs(res, n, idx + 1, seen)
        
        for i in range(n, 0, -1):
            if i in seen:
                continue
                
            if i == 1 or (idx + i < len(res) and res[idx + i] == 0):
                seen.add(i)
                res[idx] = i
                if i > 1:
                    res[idx + i] = i
                    
                if self.dfs(res, n, idx + 1, seen):
                    return True
                
                seen.remove(i)
                res[idx] = 0
                if i > 1:
                    res[idx + i] = 0
                    
        return False
            
        
            