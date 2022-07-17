from collections import defaultdict
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        counts = []
        for s in strs:
            c = Counter(s)
            counts.append((c['0'], c['1']))
        @lru_cache(None)
        def findmax(i, l, o):
            if l == 0 == o or i >= len(counts): return 0
            excl = findmax(i+1, l, o)
            zeros, ones = counts[i]
            if l >= zeros and o >= ones:
                incl = 1 + findmax(i+1, l-zeros, o-ones)
                return max(excl, incl)
            return excl
        
        return findmax(0, m, n)