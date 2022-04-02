class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None:
            return False
        n = len(nums)
        if n < 2:
            return 0
        curr_max, pre_max, times = 0, 0, 0
        for i in range(n):
            if curr_max >= n - 1:
                times += 1
                return times
            if i > pre_max:
                pre_max = curr_max
                times += 1
            curr_max = max(curr_max, i + nums[i])
            
        return times
