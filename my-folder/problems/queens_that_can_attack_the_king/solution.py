class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        ans = []
        
        def helper(x, y):
            if x == 0 and y == 0:
                return 
            r, c = king

            while ( 0 <= r < 9 and 0 <= c < 9):
                r += x
                c += y
                if [r, c] in queens:
                    ans.append([r, c])
                    return
            return
            
        for i in range(-1, 2):
            for j in range(-1, 2):
                helper(i,j)
            
        return ans