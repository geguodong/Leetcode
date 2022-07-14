class Solution:
    def twoEggDrop(self, n: int) -> int:
        test = n
        cnt = 0
        while test > 0:
            test -= cnt
            cnt += 1
        return cnt - 1