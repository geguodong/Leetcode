/*
O(n)
O(n)
Note : also could use sort
*/

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val: nums){
            pq.add(val);
        }
        int a = pq.peek()-1;
        pq.remove();
        int b = pq.peek()-1;
        return a*b;
    }
}