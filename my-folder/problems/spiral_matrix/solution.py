class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        n, m = len(matrix), len(matrix[0])
        dq = []
        if n == 1:
            return (matrix[0][j] for j in range(m))
        if m == 1:
            return (matrix[i][0] for i in range(n))
        startset, sizen, sizem = 0, n, m
        while len(dq) < m * n:
            for i in range(sizem - 1):
                dq.append(matrix[startset][startset+i])
            for j in range(sizen - 1):
                dq.append(matrix[startset+j][startset+sizem-1])
            for k in range(sizem - 1):
                dq.append(matrix[startset+sizen-1][startset+sizem-1-k])
            for l in range(sizen - 1):
                dq.append(matrix[startset+sizen-1-l][startset])
            startset += 1
            sizem -= 2
            sizen -= 2
            if sizem == sizen == 1:
                dq.append(matrix[startset][startset])
            elif sizem == 1:
                for i in range(sizen):
                    dq.append(matrix[startset+i][startset])
            elif sizen == 1:
                for i in range(sizem):
                    dq.append(matrix[startset][startset+i])
        return dq
        
            
        
        