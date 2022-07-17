class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        memo = {}
        def dp(k, n):
            if (k, n) not in memo:
                if n == 0:
                    res = 0
                elif k == 1:
                    res = n
                else:
                    low, high = 1, n
                    while low + 1 < high:
                        x = (low + high) // 2
                        t1 = dp(k - 1, x - 1)
                        t2 = dp(k, n - x)
                        if t1 < t2:
                            low = x
                        elif t1 > t2:
                            high = x
                        else:
                            low = high = x
                
                    res = 1 + min(max(dp(k - 1, x - 1), dp(k, n - x)) for x in (low, high))
                
                memo[k, n] = res
            return memo[k, n]
        return dp(k, n)
    
                              