/*
MaxHeap + Greddy
O(NlogN) for sort; could be O(N) for create heap
O(N) for store data into heap

// Could use sort directly;
// O(Nlogn)
// O(logn) for QuickSort 

*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // maxHeap for difference
        PriorityQueue<int[]> difference = new PriorityQueue<>((a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));
        // total employees
        int count = costs.length;
        // for(int[] cost : costs) {
        //     difference.add(cost);
        // } 
        difference.addAll(Arrays.asList(costs));
        
        int sumCost = 0;
        int countA = 0;
        int countB = 0;
        
        while(countA < count / 2 && countB < count / 2) {
            int[] cur = difference.poll();
            if(cur[0] >= cur[1]) {
                countB++;
                sumCost += cur[1];
            } else {
                countA++;
                sumCost += cur[0];
            }
        }
        
        if(countA < count / 2) {
            while(difference.size() > 0) {
                sumCost += difference.poll()[0];
            }
        }
        if(countB < count / 2) {
            while(difference.size() > 0) {
                sumCost += difference.poll()[1];
            }
        }
        return sumCost;
    }
}