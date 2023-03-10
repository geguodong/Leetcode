// O(NlogN) O(N)
class Solution {
    
    private int findMaxProfit(List<List<Integer>> jobs) {
        int n = jobs.size(), maxProfit = 0;
        // min heap having {endTime, profit}
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        
        for (int i = 0; i < n; i++) {
            int start = jobs.get(i).get(0);
            int end = jobs.get(i).get(1);
            int profit = jobs.get(i).get(2);
            
            // keep popping while the heap is not empty and
            // jobs are not conflicting
            // update the value of maxProfit
            while (!pq.isEmpty() && start >= pq.peek().get(0)) {
                maxProfit = Math.max(maxProfit, pq.peek().get(1));
                pq.remove();
            }
            
            ArrayList<Integer> combinedJob = new ArrayList<>();
            combinedJob.add(end);
            combinedJob.add(profit + maxProfit);
            
            // push the job with combined profit
            // if no non-conflicting job is present maxProfit will be 0
            pq.add(combinedJob);
        }
        
        // update the value of maxProfit by comparing with
        // profit of jobs that exits in the heap
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.peek().get(1));
            pq.remove();
        }
        
        return maxProfit;
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            
            jobs.add(currJob);
        }
        
        jobs.sort((a, b) -> a.get(0) - b.get(0));
        return findMaxProfit(jobs);
    }
}