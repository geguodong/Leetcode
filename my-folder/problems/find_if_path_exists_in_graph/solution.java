class Solution {
      public boolean validPath(int n, int[][] edges, int source, int destination) {    
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        
        /*every node connetion details*/
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Deque<Integer> s = new ArrayDeque<>();
        s.push(source);
        visited[source] = true;
        
        while(!s.isEmpty()){
            int currentNode = s.pop();
            if(currentNode==destination) return true;
            	for (int neighbor : map.get(currentNode)) {
            		if(!visited[neighbor]) {
                		visited[neighbor] = true;
                		s.add(neighbor);
                	}
                }
        }
        
        return false;
      }
}