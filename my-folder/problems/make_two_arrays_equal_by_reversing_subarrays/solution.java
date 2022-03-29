class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:target) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i:arr) map.put(i, map.getOrDefault(i, 0) - 1);
        for(int key: map.keySet())if (map.get(key) != 0) return false;
        return true;
    }
}