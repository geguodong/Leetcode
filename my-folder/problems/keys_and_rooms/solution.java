// BFS
// O(N + E)
// O(N)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) {
            return true;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        
        queue.add(0);
        
        while(!queue.isEmpty()) {
            int curRoom = queue.poll();
            if(visited[curRoom]) {
                continue;
            }
            visited[curRoom] = true;
            
            for(int room : rooms.get(curRoom)) {
                queue.add(room);
            }
        }
        
        for(boolean room : visited) {
            if(room == false) {
                return false;
            }
        }
        return true;
    }
}