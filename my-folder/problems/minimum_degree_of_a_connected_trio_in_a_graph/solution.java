// O(N^3)
// O(ON)
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] indegree = new int[n + 1];
        for(int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(graph[i][j]) {
                    for(int k = j + 1; k <= n; k++) {
                        if(graph[i][k] && graph[j][k]) {
                            res = Math.min(res, (indegree[i] + indegree[j] + indegree[k] - 6));
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
}