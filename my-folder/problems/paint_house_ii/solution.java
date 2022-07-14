// DP and Keep two
// O(NK) 
// O(1)
class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int houses = costs.length;
        int colors = costs[0].length;
        
        int preMin = -1;
        int preSecondMin = -1;
        int preMinColor = -1;
        // find preMin and second min
        for(int color = 0; color < colors; color++) {
            int cost = costs[0][color];
            if(preMin == -1 || preMin > cost) {
                preSecondMin = preMin;
                preMin = cost;
                preMinColor = color;
            } else if(preSecondMin == -1 || preSecondMin > cost) {
                preSecondMin = cost;
            }
        }
        
        for(int house = 1; house < houses; house++) {
            int min = -1; 
            int secondMin = -1;
            int minColor = -1;
            
            for(int color = 0; color < colors; color++) {
                int cost = costs[house][color];
                
                if(color == preMinColor) {
                    cost += preSecondMin;
                } else {
                    cost += preMin;
                }
                
                if(min == -1 || min > cost) {
                    secondMin = min;
                    minColor = color;
                    min = cost;
                } else if(secondMin == -1 || secondMin > cost) {
                    secondMin = cost;
                }
                
            }
            preMin = min;
            preSecondMin = secondMin;
            preMinColor = minColor;
        }
        
        return preMin;
        
    }
}

