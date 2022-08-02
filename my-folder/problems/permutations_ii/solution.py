class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        if nums is None:
            return nums
        n = len(nums)
        used = [False for _ in range(n)]
        res, track = [], []
        nums.sort()
        
        def backtrack():
            if len(track) == n:
                res.append(track[:])
                return 
            for i in range(n):
                if used[i]:
                    continue
                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                track.append(nums[i])
                used[i] = True
                backtrack()
                used[i] = False
                track.pop()
                
        backtrack()
        return res
                
            