class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        for row in box:
            self.processOneRow(row)
            
        return self.rotate90(box)
        
    def processOneRow(self, row):
        counter = {}
        cur = 0
        for i, x in enumerate(row):
            if x == '#':
                cur += 1
                row[i] = '.'
            elif x == '*':
                counter[i] = cur
                cur = 0
        if cur > 0:
            counter[len(row)] = cur
            
        for k, v in counter.items():
            for i in range(k - 1, k - 1 - v, -1):
                row[i] = '#'
                
    def rotate90(self, box):
        m = len(box)
        n = len(box[0])
        
        newBox = [['.'] * m for _ in range(n)]
        
        for i in range(m):
            for j in range(n):
                newBox[j][m - i - 1] = box[i][j]
                
        return newBox