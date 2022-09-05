class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int weightSum = 0;
        int maxWeight = Integer.MIN_VALUE;
        for(int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            weightSum += weight;
        }
        return binarySearch(weights, weightSum, maxWeight, days);

    }
    
    public int binarySearch(int[] weights, int total, int max, int days) {
        int left = 0;
        int right = total;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(mid >= max) {
                int count = 1;
                int curSum = 0;
                for(int i = 0; i < weights.length; i++) {
                    if(curSum + weights[i] <= mid) {
                        curSum += weights[i];
                    } else {
                        count++;
                        curSum = weights[i];
                    }
                }
                
                if(count <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
                
                
            } else {
                left = mid + 1;
            }
            
        }
        return left;
    }
}