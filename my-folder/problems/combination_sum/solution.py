class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates is None:
            return candidates
        res, track = [], []
        
        def backtrack(start = 0, sums = 0):
            if sums == target:
                res.append(track[:])
                return
            if sums > target:
                return 
            for i in range(start, len(candidates)):
                sums += candidates[i]
                track.append(candidates[i])
                backtrack(i, sums)
                track.pop()
                sums -= candidates[i]
                
        backtrack()
        return res
            