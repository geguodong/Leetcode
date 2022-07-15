class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums == None or len(nums) == 1:
            return nums
        n = len(nums)
        less = True
        for i in range(n - 1):
            if less:
                if nums[i] > nums[i + 1]:
                    nums[i], nums[i + 1] = nums[i + 1], nums[i]
            else:
                if nums[i] < nums[i + 1]:
                    nums[i], nums[i + 1] = nums[i + 1], nums[i]
            less = not less
            
                