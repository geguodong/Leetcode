class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        allTimePoints = [0] * (24 * 60)
        for tp in timePoints:
            allTimePoints[self.covertTime(tp)] += 1
            if allTimePoints[self.covertTime(tp)] > 1:
                return 0
            
        res = 24 * 60
        first = -1
        tp1 = -1
        tp2 = -1
        for i, count in enumerate(allTimePoints):
            if count != 0:
                if first < 0:
                    first = i
                tp1, tp2 = tp2, i
                if tp1 > 0 and tp2 > 0:
                    res = min(res, tp2 - tp1)
                                        
        res = min(res, 24 * 60 - (tp2 - first))
        
        return res
        
    def covertTime(self, timeStr):
        '''HH:MM => int minutes'''
        h, m = map(int, timeStr.split(':'))
        return h * 60 + m
    