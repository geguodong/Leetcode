// O(nlogn) O(n)
class Server {
    int weight;
    int index;
    public Server(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }
}

class AssignTask {
    int freeTime;
    Server server;
    
    public AssignTask(int freeTime, Server server) {
        this.freeTime = freeTime;
        this.server = server;
    }
}

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // pq to store servers
        PriorityQueue<Server> serverQueue = new PriorityQueue<>((a, b) -> {
            if(a.weight != b.weight) {
                return a.weight - b.weight;
            } else {
                return a.index - b.index;
            }
        });
        for(int i = 0; i < servers.length; i++) {
            serverQueue.add(new Server(servers[i], i));
        }
        
        PriorityQueue<AssignTask> assignQueue = new PriorityQueue<>((a, b) -> a.freeTime - b.freeTime);
        
        int j = 0;
        int time = 0;
        int[] res = new int[tasks.length];
        
        while (j < tasks.length) {
			// check what all servers have become free
            while (!assignQueue.isEmpty() && assignQueue.peek().freeTime <= time) {
                serverQueue.add(assignQueue.poll().server);
            }
			// assign tasks to available servers
            // using condition "j <= time" because accd. to question "At second j, the jth task is inserted into the queue"
            while (!serverQueue.isEmpty() && j <= time && j < tasks.length) {
                int task = tasks[j];
                Server server = serverQueue.poll();
                res[j++] = server.index;
                assignQueue.add(new AssignTask(time + task, server));   
            }
            // increase time, so that we can process next task
            if (!serverQueue.isEmpty())
                time++;
            else
                // when no servers are available, move to next available server's freeTime
				// this decreases loop iterations, since there can be a situation where time <<< next freeTime
                time = assignQueue.peek().freeTime;
        }
        return res;
    }
}