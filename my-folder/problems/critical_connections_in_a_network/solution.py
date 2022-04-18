import collections

class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        graph, conns = self.buildGraph(connections)
        ranks = [-2] * n
        self.dfs(graph, conns, ranks, 0, 0)
        return conns
        
    def buildGraph(self, connections):
        graph = collections.defaultdict(set)
        newConn = set()
        for c in connections:
            graph[c[0]].add(c[1])
            graph[c[1]].add(c[0])
            newConn.add(tuple(sorted(c)))
            
        return graph, newConn
    
    def dfs(self, graph, conns, ranks, node, depth):
        if ranks[node] >= 0:
            return ranks[node]
        
        ranks[node] = depth
        minDepth = depth
        
        for neigh in graph[node]:
            if ranks[neigh] == depth - 1:
                continue
                
            neighDepth = self.dfs(graph, conns, ranks, neigh, depth + 1)
            if neighDepth <= depth:
                conns.discard(tuple(sorted([node, neigh])))
            minDepth = min(minDepth, neighDepth)
        return minDepth
            