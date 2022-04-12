class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if 1 not in nums:
            return 1
        
        for i, num in enumerate(nums):
            if num <= 0 or num > len(nums):
                nums[i] = 1
                
        for i in range(len(nums)):
            posVal = abs(nums[i])
            nums[posVal - 1] = -abs(nums[posVal - 1])
            
        for i, num in enumerate(nums):
            if num > 0:
                return i + 1
            
        return len(nums) + 1