class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ? b - a: map.get(a) - map.get(b));
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0 ; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int n = nums.length;
        int [] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}