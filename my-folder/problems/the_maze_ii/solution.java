class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                continue;
            }
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0], col = cur[1] + dir[1];
                while (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                }
                if (maze[row - dir[0]][col - dir[1]] == 0) {
                    int dist = distance[cur[0]][cur[1]] + Math.abs(row - dir[0] - cur[0]) + Math.abs(col - dir[1] - cur[1]);
                    if (distance[row - dir[0]][col - dir[1]] > dist) {
                        queue.offer(new int[]{row - dir[0], col - dir[1]});
                        distance[row - dir[0]][col - dir[1]] = dist;
                    }
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}