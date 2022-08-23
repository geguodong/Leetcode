// HashMap to keep sum
// O(N) O(N)
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(sum, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            } 
            map.put(sum, map.getOrDefault(sum, 0 ) + 1);
        }
        return count;
    }
}