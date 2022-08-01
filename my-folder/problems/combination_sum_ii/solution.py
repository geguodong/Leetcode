from collections import OrderedDict
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        track = []
        def backtrack(start = 0, sums = 0):
            if sums == target:
                res.append(track[:])
                return
            if sums > target:
                return
            
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i -1]:
                    continue
                track.append(candidates[i])
                sums += candidates[i]
                backtrack(i + 1, sums)
                sums -= candidates[i]
                track.pop()
                
        backtrack()
        return res
            
            