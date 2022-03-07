class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        df = [0 for i in range(target+1)]
        df[0] = 1
        for num_tar in range(target+1):
            for num in nums:
                if num_tar - num >= 0:
                    df[num_tar] += df[num_tar-num]
            
        return df[target]