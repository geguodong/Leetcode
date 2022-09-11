class Solution {
    public int longestCycle(int[] edges) {
        int longest = -1;
        boolean[] visited = new boolean[edges.length];
        Map<Integer, Integer> map;
        
        for(int i = 0; i < edges.length; i++) {
            if(visited[i]) {
                continue;
            }
            int distance = 0;
            int cur = i;
            map = new HashMap<>();
            while(cur != -1) {
                if(map.containsKey(cur)) {
                    longest = Math.max(longest, distance - map.get(cur));
                    break;
                }
                if(visited[cur]) {
                    break;
                }
                visited[cur] = true;
                map.put(cur, distance);
                cur = edges[cur];
                distance++;
            }
        }
        return longest;
    }
}