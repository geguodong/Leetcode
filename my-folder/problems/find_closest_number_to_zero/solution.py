class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        if not nums:
            return nums
        n = len(nums)
        closest = float(inf)
        res = float(inf)
        for i in range(n):
            if abs(nums[i]) < closest or abs(nums[i]) == closest and nums[i] > res:
                closest = abs(nums[i])
                res = nums[i]
            
        return res
                
            