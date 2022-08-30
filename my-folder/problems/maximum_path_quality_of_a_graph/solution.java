/* backtracking : https://leetcode.com/problems/maximum-path-quality-of-a-graph/discuss/1801247/Java-or-Regular-Backtrack-or-with-explanation
 O(4^N) : There are at most four edges connected to each node.   n # of nodes
*/
class Solution {
    // Method1 - Backtrack: TC=O(4^10), SC=O(m+n)
    // n = number of nodes, m = number of edges
    int res = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        // SC=O(n)
        boolean[] visited = new boolean[n];
        visited[0] = true;
        // build graph, TC=O(m), SC=O(m)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        // backtrack with initial state
        backtrack(graph, values, visited, 0, values[0], maxTime);
        return res;
    }
    
    // TC=O(4^10)
    private void backtrack(Map<Integer, List<int[]>> graph, int[] values, boolean[] visited, int idx, int quality, int remainTime) {
        // base case: back to 0, update res
        if (idx == 0) {
            res = Math.max(res, quality);
        }
        
        // dfs neighbors
        // special case: isolated node
        if (!graph.containsKey(idx)) {
            return;
        }
        
        for (int[] nei : graph.get(idx)) {
            int nextIdx = nei[0];
            int nextTime = nei[1];
            // check time remaining and see whether can reach neighbor node
            if (remainTime - nextTime < 0) {
                continue;
            }
            
            // visited before, don't add val
            if (visited[nextIdx]) {
                backtrack(graph, values, visited, nextIdx, quality, remainTime - nextTime);
            }
            // not visted before, add val
            else {
                visited[nextIdx] = true;
                backtrack(graph, values, visited, nextIdx, quality + values[nextIdx], remainTime - nextTime);
                // backtrack for next path
                visited[nextIdx] = false;
            }
        }        
    }
}