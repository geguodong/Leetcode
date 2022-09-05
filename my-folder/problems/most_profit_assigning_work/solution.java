/*
Time Complexity: O(NlogN+QlogQ), where N is the number of jobs, and Q is the number of people.
Space Complexity: O(N), the additional space used by jobs.
*/

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        List<List<Integer>> jobs = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            jobs.add(Arrays.asList(difficulty[i], profit[i]));
        }
            
        Collections.sort(jobs, (a, b) -> {
            if(a.get(0) < b.get(0)) {
                return -1;
            }
            return 1;
           // return a.get(0) - b.get(0);
        });
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0; // We don't reset them O(N + Q)
        for (int skill: worker) {
            while (i < N && skill >= jobs.get(i).get(0)) {
                best = Math.max(best, jobs.get(i).get(1));
                i++;
            }
            ans += best;
        }

        return ans;
    }
}