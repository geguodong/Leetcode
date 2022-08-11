class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, List<Integer>> neighs = new HashMap<>();
        for(int[] pair : adjacentPairs) {
            count.put(pair[0], count.getOrDefault(pair[0], 0) + 1);
            count.put(pair[1], count.getOrDefault(pair[1], 0) + 1);
            List<Integer> neigh0= neighs.getOrDefault(pair[0], new ArrayList<>());
            neigh0.add(pair[1]);
            neighs.put(pair[0], neigh0);
            List<Integer> neigh1= neighs.getOrDefault(pair[1], new ArrayList<>());
            neigh1.add(pair[0]);
            neighs.put(pair[1], neigh1);
        }
        
        int start = 0;
        for(Integer key : count.keySet()) {
            if(count.get(key) == 1) {
                start = key;
                break;
            }
        }
        int[] res = new int[count.size()];
        int index = 0;
        res[index] = start;
        index++;
        while(index < res.length) {
            if(neighs.get(res[index - 1]).size() == 1) {
                res[index] = neighs.get(res[index - 1]).get(0);
            } else {
                res[index] = neighs.get(res[index - 1]).get(0) == res[index - 2] ? neighs.get(res[index - 1]).get(1) : neighs.get(res[index - 1]).get(0);
            }
            index++;
        }
        return res;
    }
}