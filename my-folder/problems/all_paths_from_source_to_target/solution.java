/*
Time Complexity: O(2^N ⋅N)

As we calculate shortly before, there could be at most 2^{N-1} - 12 
N−1
 −1 possible paths in the graph.

For each path, there could be at most N-2N−2 intermediate nodes, i.e. it takes \mathcal{O}(N)O(N) time to build a path.

To sum up, a loose upper-bound on the time complexity of the algorithm would be (2^{N-1} - 1) \cdot \mathcal{O}(N) = \mathcal{O}(2^N \cdot N)(2 
N−1
 −1)⋅O(N)=O(2 
N
 ⋅N), where we consider it takes \mathcal{O}(N)O(N) efforts to build each path.

It is a loose uppper bound, since we could have overlapping among the paths, therefore the efforts to build certain paths could benefit others.

Space Complexity: Time Complexity: O(2^N ⋅N)

Similarly, since at most we could have 2^{N-1}-12 
N−1
 −1 paths as the results and each path can contain up to NN nodes, the space we need to store the results would be \mathcal{O}(2^N \cdot N)O(2 
N
 ⋅N).

Since we also applied recursion in the algorithm, the recursion could incur additional memory consumption in the function call stack. The stack can grow up to NN consecutive calls. Meanwhile, along with the recursive call, we also keep the state of the current path, which could take another \mathcal{O}(N)O(N) space. Therefore, in total, the recursion would require additional \mathcal{O}(N)O(N) space.

To sum up, the space complexity of the algorithm is \mathcal{O}(2^N \cdot N) + \mathcal{O}(N) = \mathcal{O}(2^N \cdot N)O(2 
N
 ⋅N)+O(N)=O(2 
N
 ⋅N).

*/

// back tracking
class Solution {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return this.results;
    }
}