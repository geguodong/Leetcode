from copy import deepcopy
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None:
            return nums
        res = []
        def backtrack(start = 0, track = []):
            res.append(track[:])
            
            for i in range(start, len(nums)):
                track.append(nums[i])
                backtrack(i + 1, track)
                track.pop()
                
        backtrack()
        return res