class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1
        n = len(nums)
        left, right = 0, n - 1
        if n == 1:
            return 0
        while(left + 1 < right):
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid
        if nums[left] < nums[right]:
            return right
        else:
            return left
    '''
        while(left < right):
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1
        return left
    '''